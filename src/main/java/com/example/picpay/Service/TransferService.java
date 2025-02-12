package com.example.picpay.Service;

import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;
import com.example.picpay.DTO.TransferDTO;
import com.example.picpay.Exception.ErrorTransfer;
import com.example.picpay.Exception.NotAuthorized;
import com.example.picpay.Exception.TransferNotAllowedForWalletTypeException;
import com.example.picpay.Exception.WalletNotFoundException;
import com.example.picpay.Models.Transfer;
import com.example.picpay.Models.Wallet_Client;
import com.example.picpay.Repository.TrasnferRep;
import com.example.picpay.Repository.Wallet_Client_Rep;

@Service
public class TransferService {

    private final TrasnferRep tr;
    private final AuthorizationService authorizationService;
    private final Notification notification;
    private final Wallet_Client_Rep wcr;    

    
    public TransferService(TrasnferRep tr, 
    AuthorizationService authorizationService,
    Notification notification,
    Wallet_Client_Rep wcr) {
        this.tr = tr;
        this.authorizationService = authorizationService;
        this.notification = notification;
        this.wcr = wcr;
    }

    private void validateTransfer(TransferDTO dto, Wallet_Client sender) {
        if(!sender.isTransferAllowedForWalletType())
        {
            throw new TransferNotAllowedForWalletTypeException();
        }
        if(!sender.isBalance(dto.value()))
        {
            throw new ErrorTransfer();
        }
        
        if(authorizationService.isAuthorized(dto))
        {
            throw new NotAuthorized();
        }
    }

    

    public Transfer transfer(TransferDTO dto) {
        var sender = wcr.findById(dto.payer()).orElseThrow(() -> new WalletNotFoundException(dto.payer()));
        var reciver = wcr.findById(dto.payee()).orElseThrow(() -> new WalletNotFoundException(dto.payee())); 
        validateTransfer(dto,sender);
        sender.debit(dto.value());
        reciver.credit(dto.value());

        var transfer = new Transfer(sender, reciver, dto.value());

        wcr.save(sender);
        wcr.save(reciver);
        var transferResult = tr.save(transfer);

        CompletableFuture.runAsync(() -> notification.sendnotification(transferResult));

        return transferResult;
    }    
}
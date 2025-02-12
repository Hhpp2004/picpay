package com.example.picpay.Service;

import org.springframework.stereotype.Service;

import com.example.picpay.DTO.CreateWalletDto;
import com.example.picpay.Exception.CostumerDataAlreadyExistsExeception;
import com.example.picpay.Models.Wallet_Client;
import com.example.picpay.Repository.Wallet_Client_Rep;

@Service
public class WalletService {

    private final Wallet_Client_Rep wcr;

    public WalletService(Wallet_Client_Rep wcr) {
        this.wcr = wcr;
    }

    public Wallet_Client createWallet(CreateWalletDto dto) {    
        var walletdb = wcr.findByCpfCnpjOrEmail(dto.cpf_cnpj(),dto.email());        
        if(walletdb.isPresent())
        {
            throw new CostumerDataAlreadyExistsExeception("Cpf Cnpj or email already exists");
        }
        return wcr.save(dto.towallet());
    }
    
}

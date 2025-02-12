package com.example.picpay.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.picpay.DTO.CreateWalletDto;
import com.example.picpay.Models.Wallet_Client;
import com.example.picpay.Service.WalletService;

import jakarta.validation.Valid;

@RestController
public class PicPayController {
    private WalletService ws;


    public PicPayController(WalletService ws) {
        this.ws = ws;
    }

    @PostMapping("/wallet")
    public ResponseEntity<Wallet_Client> create_wallet(@RequestBody @Valid CreateWalletDto dto)
    {   
        var wallet = ws.createWallet(dto);
        return ResponseEntity.ok(wallet);
    }

}

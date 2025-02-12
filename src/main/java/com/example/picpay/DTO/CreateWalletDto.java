package com.example.picpay.DTO;

import com.example.picpay.Models.Type_Wallet;
import com.example.picpay.Models.Wallet_Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String cpf_cnpj,@NotBlank String email,
@NotBlank String fullname,@NotBlank String password,@NotNull Type_Wallet.Type_Enum typewallet) {
    

    public Wallet_Client towallet()
    {
        return new Wallet_Client(
            cpf_cnpj,
            email,
            fullname,
            password,
            typewallet.get()
        );
    }
}

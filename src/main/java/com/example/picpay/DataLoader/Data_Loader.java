package com.example.picpay.DataLoader;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.picpay.Models.Type_Wallet;
import com.example.picpay.Repository.Type_Wallet_Rep;

@Configuration
public class Data_Loader implements CommandLineRunner {

    private final Type_Wallet_Rep twr;

    public Data_Loader(Type_Wallet_Rep type_Wallet_Rep) {
        this.twr = type_Wallet_Rep;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Type_Wallet.Type_Enum.values())
              .forEach(typewallet -> twr.save(typewallet.get()));
    }
}
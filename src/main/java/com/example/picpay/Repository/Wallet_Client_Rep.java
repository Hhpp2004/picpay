package com.example.picpay.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.picpay.Models.Wallet_Client;

public interface Wallet_Client_Rep extends JpaRepository<Wallet_Client,Long>{

    Optional<Wallet_Client> findByCpfCnpjOrEmail(String cpf_cnpj, String email);
    
}

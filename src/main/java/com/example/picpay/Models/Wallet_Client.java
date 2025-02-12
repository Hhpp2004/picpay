package com.example.picpay.Models;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet_client")
public class Wallet_Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cpf_cnpj",unique = true)
    private String cpfCnpj;
    @Column(name="email",unique = true)
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name="password")
    private String password;
    @Column(name="balance")
    private BigDecimal balance = BigDecimal.ZERO;
    @JoinColumn(name = "type_wallet")
    @ManyToOne
    private Type_Wallet typewallet;

    public Wallet_Client() {
    }

    public Wallet_Client(Long id, String cpfCnpj, String email, String fullname, String password, BigDecimal balance,
            Type_Wallet typewallet) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.balance = balance;
        this.typewallet = typewallet;
    }

    public Wallet_Client(String cpfCnpj, String email, String fullname, String password, Type_Wallet typewallet) {
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.typewallet = typewallet;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Type_Wallet getTypewallet() {
        return typewallet;
    }

    public void setTypewallet(Type_Wallet typewallet) {
        this.typewallet = typewallet;
    }

    public boolean isTransferAllowedForWalletType() {
        return this.typewallet.equals(Type_Wallet.Type_Enum.USER.get());
    }

    public boolean isBalance(BigDecimal value) {
        return this.balance.doubleValue() >= value.doubleValue();
    }

    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }
}

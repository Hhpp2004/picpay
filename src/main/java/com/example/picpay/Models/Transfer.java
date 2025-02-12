package com.example.picpay.Models;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transferid;
    @ManyToOne
    @JoinColumn(name = "sender") 
    private Wallet_Client sender;
    @ManyToOne
    @JoinColumn(name = "reciver")
    private Wallet_Client reciver;
    @JoinColumn(name = "value")
    private BigDecimal value;
    public Transfer() {
    }
    public UUID getTransferid() {
        return transferid;
    }
    public void setTransferid(UUID transferid) {
        this.transferid = transferid;
    }
    public Wallet_Client getSender() {
        return sender;
    }
    public void setSender(Wallet_Client sender) {
        this.sender = sender;
    }
    public Wallet_Client getReciver() {
        return reciver;
    }
    public void setReciver(Wallet_Client reciver) {
        this.reciver = reciver;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public Transfer(Wallet_Client sender, Wallet_Client reciver, BigDecimal value) {
        this.sender = sender;
        this.reciver = reciver;
        this.value = value;
    }

    

}

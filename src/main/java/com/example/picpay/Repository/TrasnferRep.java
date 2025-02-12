package com.example.picpay.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpay.Models.Transfer;

public interface TrasnferRep extends JpaRepository<Transfer,UUID> {
    
}

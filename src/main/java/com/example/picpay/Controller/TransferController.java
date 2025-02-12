package com.example.picpay.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.picpay.DTO.TransferDTO;
import com.example.picpay.Models.Transfer;
import com.example.picpay.Service.TransferService;

import jakarta.validation.Valid;

@RestController
public class TransferController {
    private final TransferService ts;

    public TransferController(TransferService ts) {
        this.ts = ts;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto)
    {
        var resp = ts.transfer(dto);
        return ResponseEntity.ok(resp);
        
    }
} 

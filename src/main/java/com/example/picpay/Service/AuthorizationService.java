package com.example.picpay.Service;

import org.springframework.stereotype.Service;

import com.example.picpay.Client.AuthorizationClient;
import com.example.picpay.DTO.TransferDTO;
import com.example.picpay.Exception.PicpayExe;


@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }
    
    @SuppressWarnings("null")
    public boolean isAuthorized(TransferDTO trans)
    {
        var resp = authorizationClient.isAuthorized();
        if(resp.getStatusCode().isError())
        {
            throw new PicpayExe();
        }
        return resp.getBody().authorized();
    }
}

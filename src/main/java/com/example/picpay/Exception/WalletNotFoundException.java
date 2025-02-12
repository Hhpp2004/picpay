package com.example.picpay.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicpayExe{

    private Long walletID;

    public WalletNotFoundException(Long walletID) {
        this.walletID = walletID;
    }

    @Override
    public ProblemDetail toProblemDetail()
    {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("422 - Wallet not found");
        pb.setDetail("There is no wallet with id "+walletID);
        return pb;
    }
}

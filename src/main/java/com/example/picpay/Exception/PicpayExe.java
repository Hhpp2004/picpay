package com.example.picpay.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicpayExe extends RuntimeException {
    public ProblemDetail toProblemDetail()
    {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("500 - PicPay internal server error");
        return pb;
    }
}

package com.example.picpay.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NotAuthorized extends PicpayExe{

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setDetail("Transfer not authorazed");
        return pb;
    }
    
}

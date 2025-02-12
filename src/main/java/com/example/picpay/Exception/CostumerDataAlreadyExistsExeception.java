package com.example.picpay.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CostumerDataAlreadyExistsExeception extends PicpayExe {
    
    private String detail;

    

    public CostumerDataAlreadyExistsExeception(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail()
    {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("This data exists");
        pb.setDetail(detail);
        return super.toProblemDetail();
    }
}

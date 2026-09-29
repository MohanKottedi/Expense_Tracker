package com.mohan.expensetracker.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ErrorResponse {
    HttpStatus httpStatus;
    String msg;
    String details;
    String error;
    public ErrorResponse(HttpStatus httpStatus,String msg,String details,String error){
        this.httpStatus = httpStatus;
        this.msg = msg;
        this.details = details;
        this.error = error;
    }

}

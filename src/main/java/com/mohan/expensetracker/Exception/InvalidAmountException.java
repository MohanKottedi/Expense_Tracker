package com.mohan.expensetracker.Exception;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(){
        super();
    }
    public InvalidAmountException(String msg){
        super(msg);
    }
}

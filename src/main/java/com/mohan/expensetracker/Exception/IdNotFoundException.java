package com.mohan.expensetracker.Exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(){
        super();
    }
    public IdNotFoundException(String msg){
        super(msg);
    }
}

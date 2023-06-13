package com.mentoriatiago.integramarketplace.exceptionsAndValidations;

public class BadRequest extends RuntimeException{
    public BadRequest(String error){
        super(error);
    }
}

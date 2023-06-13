package com.mentoriatiago.integramarketplace.exceptionsAndValidations;

public class AlreadyRegistered extends RuntimeException{
    public AlreadyRegistered(String error){
        super(error);
    }
}

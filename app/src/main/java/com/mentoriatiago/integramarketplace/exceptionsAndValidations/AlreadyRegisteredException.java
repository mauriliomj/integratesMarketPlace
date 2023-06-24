package com.mentoriatiago.integramarketplace.exceptionsAndValidations;

public class AlreadyRegisteredException extends RuntimeException{
    public AlreadyRegisteredException(String error){
        super(error);
    }
}

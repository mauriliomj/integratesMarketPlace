package com.mentoriatiago.integramarketplace.exceptions;

public class AlreadyRegistered extends RuntimeException{
    AlreadyRegistered(String erro){
        super(erro);
    }
}

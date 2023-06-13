package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;

import java.util.Date;


@Getter
public class CreatedDate {
    Date createdDate = new Date();

    @Override
    public String toString() {
        return createdDate.toString();
    }
}

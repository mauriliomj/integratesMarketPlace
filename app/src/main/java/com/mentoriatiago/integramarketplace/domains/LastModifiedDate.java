package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LastModifiedDate {
    private Date modifiedDate = new Date();

    @Override
    public String toString() {
        return modifiedDate.toString();
    }
}

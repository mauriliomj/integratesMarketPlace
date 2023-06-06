package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.GregorianCalendar;

@Getter
@Setter
public class LastModifiedDate {
    private GregorianCalendar modifiedDate = new GregorianCalendar();

}

package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public Address(String street, String number, String zipcode, String city, String state, String country){
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}

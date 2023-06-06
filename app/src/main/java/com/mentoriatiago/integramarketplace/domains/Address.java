package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class Address {
    @Indexed
    private String street;
    @Indexed
    private String number;
    @Indexed
    private String zipcode;
    @Indexed
    private String city;
    @Indexed
    private String state;
    @Indexed
    private String country;

}

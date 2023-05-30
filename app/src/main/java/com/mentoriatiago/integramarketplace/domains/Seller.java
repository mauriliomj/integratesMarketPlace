package com.mentoriatiago.integramarketplace.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@EqualsAndHashCode
public class Seller {

    @Id
    private SellerId sellerId;
    @Indexed
    private String name;
    @Indexed
    private String registrationCode;
    @Indexed
    private Contact contact;
    @Indexed
    private Address address;

}

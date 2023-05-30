package com.mentoriatiago.integramarketplace.gateways.jsons;

import com.mentoriatiago.integramarketplace.domains.Address;
import com.mentoriatiago.integramarketplace.domains.Contact;
import com.mentoriatiago.integramarketplace.domains.Seller;
import lombok.Getter;

@Getter
public class SellerResponse {
    private Integer sellerId;
    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;

    public SellerResponse(Seller seller) {
        this.sellerId = seller.getSellerId().getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = seller.getContact();
        this.address = seller.getAddress();
    }

}

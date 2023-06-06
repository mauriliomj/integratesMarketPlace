package com.mentoriatiago.integramarketplace.gateways.jsons;

import com.mentoriatiago.integramarketplace.domains.*;
import lombok.Getter;

@Getter
public class SellerResponse {
    private Integer sellerId;
    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;
    //private CreatedDate createdDate;
    //private LastModifiedDate lastModifiedDate;

    public SellerResponse(Seller seller) {
        this.sellerId = seller.getSellerId().getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = seller.getContact();
        this.address = seller.getAddress();
        //this.createdDate = seller.getCreatedDate();
        //this.lastModifiedDate = seller.getLastModifiedDate();
    }

}

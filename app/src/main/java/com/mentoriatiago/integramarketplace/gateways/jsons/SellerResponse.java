package com.mentoriatiago.integramarketplace.gateways.jsons;

import com.mentoriatiago.integramarketplace.domains.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Getter
@Setter
public class SellerResponse {
    private String sellerId;
    private String name;
    private String registrationCode;
    private Contact contact;
    private Address address;
    private String createdDate;
    private String lastModifiedDate;

    public SellerResponse(Seller seller) {
        this.sellerId = seller.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contact = seller.getContact();
        this.address = seller.getAddress();
        this.createdDate = seller.getCreatedDate();
        this.lastModifiedDate = seller.getLastModifiedDate();
    }
}

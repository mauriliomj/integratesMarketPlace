package com.mentoriatiago.integramarketplace.gateways.controllers;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.domains.SellerId;
import com.mentoriatiago.integramarketplace.gateways.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.repositories.SellersRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SellersController {

    @Autowired
    private SellersRepository sellersRepository;

    @PostMapping
    @ApiOperation("Adiciona um novo vendedor!")
    public void addSellers(@Validated @RequestBody SellerRequest sellerRequest){
        Seller seller = sellerRequest.toDomain();
        if (sellersRepository.equals(sellerRequest)){
            throw new RuntimeException();
        } else{
            SellerId sellerId = new SellerId();
            seller.setSellerId(sellerId);
            this.sellersRepository.save(seller);
        }

    }

}

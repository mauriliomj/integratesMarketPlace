package com.mentoriatiago.integramarketplace.repositories;

import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.domains.SellerId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellersRepository extends MongoRepository<Seller, String> {
    public default Boolean findByName(String name){
        return true;
    }

    public default Boolean findByRegistrationCode(String registrationCode){
        return true;
    }

    public default String findAll(Seller seller){
        return seller.toString();
    }
}

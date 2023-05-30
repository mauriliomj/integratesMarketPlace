package com.mentoriatiago.integramarketplace.repositories;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellersRepository extends MongoRepository<Seller, String> {
}

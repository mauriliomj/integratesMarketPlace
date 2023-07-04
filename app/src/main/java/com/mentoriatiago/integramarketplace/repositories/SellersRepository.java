package com.mentoriatiago.integramarketplace.repositories;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellersRepository extends PagingAndSortingRepository<Seller, String> {

    @Query(value = "{}")
    @Override
    Page<Seller> findAll(Pageable pageable);

    public Optional<Seller> findByRegistrationCode(String registrationCode);

    public Optional<Seller> findById(String sellerId);

    public boolean existsById(String sellerId);



}

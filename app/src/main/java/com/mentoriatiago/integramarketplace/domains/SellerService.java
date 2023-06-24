package com.mentoriatiago.integramarketplace.domains;

import com.mentoriatiago.integramarketplace.domains.Seller;
import org.springframework.data.domain.Page;
import com.mentoriatiago.integramarketplace.repositories.SellersRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    private static SellersRepository sellersRepository = null;

    public SellerService(SellersRepository sellersRepository){
        this.sellersRepository = sellersRepository;
    }

    public static Page<Seller> getSellers(int pageNumber, int pageSize){
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        return sellersRepository.findAll(pageable);
    }
}

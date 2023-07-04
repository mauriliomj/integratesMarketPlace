package com.mentoriatiago.integramarketplace.domains;

import com.mentoriatiago.integramarketplace.exceptionsAndValidations.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.NotFound;
import com.mentoriatiago.integramarketplace.gateways.jsons.SellerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.mentoriatiago.integramarketplace.repositories.SellersRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellersRepository sellersRepository;

    public CustomPage<Seller> getSellers(Pageable pageable){
        Page<Seller> sellersPage = sellersRepository.findAll(pageable);

        List<Seller> sellers = sellersPage.getContent();
        PaginationData paginationData = new PaginationData();
        paginationData.setPageNumber(sellersPage.getNumber());
        paginationData.setPageSize(sellersPage.getSize());
        paginationData.setTotalPages(sellersPage.getTotalPages());
        paginationData.setTotalElements(sellersPage.getTotalElements());

        return new CustomPage<>(sellers, paginationData);
    }

    public Optional<Seller> findByRegistrationCode(String registrationCode){
        return sellersRepository.findByRegistrationCode(registrationCode);
    }

    public Optional<Seller> findById(String sellerId){
        return sellersRepository.findById(sellerId);
    }

    public boolean existsById(String sellerId){
        return sellersRepository.existsById(sellerId);
    }

    public void save(Seller seller){
        sellersRepository.save(seller);
    }

    public void postOperation(SellerRequest sellerRequest){
        Seller seller = sellerRequest.toDomain();
        if(findByRegistrationCode(seller.getRegistrationCode()).isPresent()){
            throw new AlreadyRegisteredException("Seller já registrado!");
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(new CreatedDate().toString());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            save(seller);
        }
    }

    public Optional<Seller> updateSeller(String sellerId, SellerRequest updatedSeller){
        Optional<Seller> existingSeller = sellersRepository.findById(sellerId);
        Seller seller = updatedSeller.toDomain();

        if (existingSeller.isPresent()) {
            seller.setCreatedDate(existingSeller.get().getCreatedDate());
            seller.setSellerId(existingSeller.get().getSellerId());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            sellersRepository.save(seller);

            return sellersRepository.findById(sellerId);

        } else {
            throw new NotFound("Seller não encontrado!");
        }
    }

    public Optional<Seller> getSellerById(String sellerId){
        if(sellersRepository.existsById(sellerId)){
            return sellersRepository.findById(sellerId);
        } else{
            throw new NotFound(sellerId+" Id não encontrado!");
        }
    }
}

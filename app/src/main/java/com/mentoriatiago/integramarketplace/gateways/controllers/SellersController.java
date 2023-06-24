package com.mentoriatiago.integramarketplace.gateways.controllers;

import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.NotFound;
import com.mentoriatiago.integramarketplace.gateways.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.repositories.SellersRepository;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Getter
@Validated
@RestController
@RequestMapping(value = "/sellers")
public class SellersController {

    @Autowired
    private static SellersRepository sellersRepository;



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation("Adiciona um novo seller!")
    public void addSellers(@Valid @RequestBody SellerRequest sellerRequest){
        Seller seller = sellerRequest.toDomain();
        if(sellersRepository.findByRegistrationCode(seller.getRegistrationCode()).isPresent()){
                throw new AlreadyRegisteredException("Seller já registrado!");
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(new CreatedDate().toString());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            this.sellersRepository.save(seller);
        }
    }

    @GetMapping
    @ApiOperation("Lista os sellers cadastrados.")
    public Page<Seller> getSellers(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        return SellerService.getSellers(page, size);
    }

    @PutMapping(value ="/{sellerId}")
    @ApiOperation("Atualiza/modifica os sellers cadastrados.")
    public Optional<Seller> updateSeller(@PathVariable String sellerId, @RequestBody SellerRequest updatedSeller) throws NotFound {
        Optional<Seller> existingSeller = this.sellersRepository.findById(sellerId);

        if(existingSeller.isPresent()){
            Seller seller = existingSeller.get();
            seller.setName(updatedSeller.getName());
            seller.setRegistrationCode(updatedSeller.getRegistrationCode());
            seller.setContact(updatedSeller.getContact());
            seller.setAddress(updatedSeller.getAddress());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            sellersRepository.save(seller);

            return sellersRepository.findById(sellerId);
        } else{
            throw new NotFound("Seller não encontrado!");
        }
    }

    @GetMapping("/{sellerId}")
    public Optional<Seller> getSeller(String id){
        if(this.sellersRepository.existsById(id)){
            return this.sellersRepository.findById(id);
        } else{
            throw new NotFound(id+" Id não encontrado!");
        }
    }
}

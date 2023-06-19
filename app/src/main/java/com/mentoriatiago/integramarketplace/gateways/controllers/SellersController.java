package com.mentoriatiago.integramarketplace.gateways.controllers;

import com.mentoriatiago.integramarketplace.domains.CreatedDate;
import com.mentoriatiago.integramarketplace.domains.LastModifiedDate;
import com.mentoriatiago.integramarketplace.domains.Seller;
import com.mentoriatiago.integramarketplace.domains.SellerId;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.AlreadyRegistered;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.NotFound;
import com.mentoriatiago.integramarketplace.gateways.jsons.SellerRequest;
import com.mentoriatiago.integramarketplace.repositories.SellersRepository;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Getter
@Validated
@RestController
@RequestMapping(value = "/sellers")
public class SellersController {

    @Autowired
    private SellersRepository sellersRepository;


    @PostMapping
    @ApiOperation("Adiciona um novo seller!")
    public void addSellers(@Valid @RequestBody SellerRequest sellerRequest){
        Seller seller = sellerRequest.toDomain();

        if (sellersRepository.findByName(seller.getName())){
            if(sellersRepository.findByRegistrationCode(seller.getRegistrationCode())){
                throw new AlreadyRegistered("Seller já registrado!");
            }
        } else{
            seller.setSellerId(new SellerId().selerId());
            seller.setCreatedDate(new CreatedDate().toString());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            this.sellersRepository.save(seller);
        }
    }

    @GetMapping
    @ApiOperation("Lista os sellers cadastrados.")
    public List<Seller> sellersList(){
        return this.sellersRepository.findAll();

    }

    @PutMapping("/{sellerId}")
    @ApiOperation("Atualiza/modifica os sellers cadastrados.")
    public String updateSeller(@PathVariable String id, @RequestBody SellerRequest updatedSeller) throws NotFound {
        Optional<Seller> existingSeller = this.sellersRepository.findById(id);

        if(existingSeller.isPresent()){
            Seller seller = existingSeller.get();
            seller.setName(existingSeller.get().getName());
            seller.setRegistrationCode(existingSeller.get().getRegistrationCode());
            seller.setContact(existingSeller.get().getContact());
            seller.setAddress(existingSeller.get().getAddress());
            seller.setLastModifiedDate(new LastModifiedDate().toString());
            sellersRepository.save(seller);

            return sellersRepository.findAll(seller);
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

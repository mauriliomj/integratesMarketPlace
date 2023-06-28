package com.mentoriatiago.integramarketplace.gateways.controllers;

import com.mentoriatiago.integramarketplace.domains.*;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.AlreadyRegisteredException;
import com.mentoriatiago.integramarketplace.exceptionsAndValidations.NotFound;
import com.mentoriatiago.integramarketplace.gateways.jsons.SellerRequest;
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
    private SellerService sellersService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation("Adiciona um novo seller!")
    public void addSellers(@Valid @RequestBody SellerRequest sellerRequest) {
        sellersService.postOperation(sellerRequest);
    }

    @GetMapping
    @ApiOperation("Lista os sellers cadastrados.")
    public Page<Seller> getSellers(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
        return sellersService.getSellers(page, size);
    }

    @PutMapping(value ="/{sellerId}")
    @ApiOperation("Atualiza/modifica os sellers cadastrados.")
    public Optional<Seller> updateSeller(@PathVariable String sellerId, @RequestBody SellerRequest updatedSeller) throws NotFound {
        return sellersService.updateSeller(sellerId, updatedSeller);
    }

    @GetMapping("/{sellerId}")
    public Optional<Seller> getSeller(String sellerId){
        return sellersService.getSellerById(sellerId);
    }
}

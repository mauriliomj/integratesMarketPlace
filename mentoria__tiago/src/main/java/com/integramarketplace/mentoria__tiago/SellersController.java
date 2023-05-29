package integramarketplace.mentoriatiago.integraMarketPlace;

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
    public void addSellers(@Validated @RequestBody SellersRequest sellersRequest){
        Sellers seller = sellersRequest.toDomain();
        if (sellersRepository.equals(sellersRequest)){
            throw new RuntimeException();
        } else{
            SellerId sellerId = new SellerId();
            seller.setSellerId(sellerId);
            this.sellersRepository.save(seller);
        }

    }

}

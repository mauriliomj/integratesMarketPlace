package integramarketplace.mentoriatiago.integraMarketPlace;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Random;

@Getter
@EqualsAndHashCode
public class SellerId {

    private Integer sellerId;

    public Integer sellerId(){
        Random random = new Random();
        sellerId = random.nextInt(10000);
        return sellerId;
    }
}

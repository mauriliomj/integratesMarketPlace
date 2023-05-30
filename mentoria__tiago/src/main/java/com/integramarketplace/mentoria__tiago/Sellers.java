package integramarketplace.mentoriatiago.integraMarketPlace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Sellers {

    @Id
    private integramarketplace.mentoriatiago.integraMarketPlace.SellerId sellerId;
    @Indexed
    private String name;
    @Indexed
    private String registrationCode;
    @Indexed
    private integramarketplace.mentoriatiago.integraMarketPlace.Contacts contacts;
    @Indexed
    private integramarketplace.mentoriatiago.integraMarketPlace.Address address;

}

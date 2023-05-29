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
    private SellerId sellerId;
    @Indexed
    private String name;
    @Indexed
    private String registrationCode;
    @Indexed
    private Contacts contacts;
    @Indexed
    private Address address;

}

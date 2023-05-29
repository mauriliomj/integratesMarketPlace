package integramarketplace.mentoriatiago.integraMarketPlace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SellersRequest {

    @NonNull private String name;
    @NonNull private String registrationCode;
    private Contacts contacts;
    private Address address;

    public Sellers toDomain(){
        Sellers seller = new Sellers();
        seller.setName(name);
        seller.setRegistrationCode(registrationCode);
        seller.setContacts(contacts);
        seller.setAddress(address);
        return seller;
    }
}

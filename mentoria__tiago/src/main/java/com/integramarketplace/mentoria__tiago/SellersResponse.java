package integramarketplace.mentoriatiago.integraMarketPlace;

import lombok.Getter;

@Getter
public class SellersResponse {
    private Integer sellerId;
    private String name;
    private String registrationCode;
    private Contacts contacts;
    private Address address;

    public SellersResponse(Sellers seller, SellerId sellerId){
        this.sellerId = sellerId.getSellerId();
        this.name = seller.getName();
        this.registrationCode = seller.getRegistrationCode();
        this.contacts = seller.getContacts();
        this.address = seller.getAddress();
    }

}

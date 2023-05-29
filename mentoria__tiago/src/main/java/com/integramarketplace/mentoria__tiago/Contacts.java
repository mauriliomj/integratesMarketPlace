package integramarketplace.mentoriatiago.integraMarketPlace;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contacts {
    private String type;
    private String email;
    public Contacts(String type, String email){
        this.type = type;
        this.email = email;
    }
}

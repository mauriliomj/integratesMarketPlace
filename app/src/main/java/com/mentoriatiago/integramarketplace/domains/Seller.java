package com.mentoriatiago.integramarketplace.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document("sellers")
public class Seller {

    @Id
    private String sellerId;
    @Indexed
    private String name;
    @Indexed
    private String registrationCode;
    @Indexed
    private Contact contact;
    @Indexed
    private Address address;
    @Indexed
    private String createdDate;
    @Indexed
    private String lastModifiedDate;

}

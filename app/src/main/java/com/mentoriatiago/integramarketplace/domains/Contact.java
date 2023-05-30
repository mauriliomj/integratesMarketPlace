package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private ContactTypeEnum type;
    private String value;

    public Contact(ContactTypeEnum type, String value) {
        this.type = type;
        this.value = value;
    }
}

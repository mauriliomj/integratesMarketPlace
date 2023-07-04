package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CustomPage<T> {
    private List<T> content;
    private PaginationData paginationData;

    public CustomPage(List<T> content, PaginationData paginationData){
        this.content = content;
        this.paginationData = paginationData;
    }
}

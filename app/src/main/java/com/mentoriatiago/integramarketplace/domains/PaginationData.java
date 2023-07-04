package com.mentoriatiago.integramarketplace.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationData {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElements;
}

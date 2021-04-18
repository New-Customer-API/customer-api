package br.com.customer.api.customer.api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageableResponseDto {

    private Integer currentPage;
    private Boolean first;
    private Boolean last;
    private Integer numberOfElements;
    private Long totalElements;
    private Integer totalPages;

}

package br.com.customer.api.customer.api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListWrapper<T> {

    private List<T> data;

    private PageableResponseDto pagination;

}

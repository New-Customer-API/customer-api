package br.com.customer.api.customer.api.api.dto;

import lombok.Getter;

@Getter
public class PageRequestDto {

    private Integer page;

    private Integer size;

    public PageRequestDto(final Integer page, final Integer size) {
        this.page = page == null ? 0 : page - 1;
        this.size = size == null ? 10 : size;
    }

    public void setPage(Integer page) {
        this.page = page - 1;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

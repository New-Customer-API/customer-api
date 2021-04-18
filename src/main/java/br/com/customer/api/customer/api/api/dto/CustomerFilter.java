package br.com.customer.api.customer.api.api.dto;

import lombok.Data;

@Data
public class CustomerFilter {

    private String fullName;
    private String nickName;
    private String document;
    private String documentType;
    private String email;
    private String country;
    private String city;
    private String state;
    private String neighborhood;
    private String complement;
    private String number;
    private String countryCode;
    private String areaCode;
    private String phoneNumber;

}

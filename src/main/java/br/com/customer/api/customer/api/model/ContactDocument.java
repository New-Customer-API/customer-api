package br.com.customer.api.customer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDocument implements BaseDocument {

    private String countryCode;
    private String areaCode;
    private String phoneNumber;

}

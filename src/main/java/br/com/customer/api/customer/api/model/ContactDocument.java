package br.com.customer.api.customer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The customer'contact
 * @author amanda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDocument {

    private String countryCode;
    private String areaCode;
    private String phoneNumber;

}

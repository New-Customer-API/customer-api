package br.com.customer.api.customer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The address'contact
 * @author amanda
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDocument {

    private String country;
    private String city;
    private String state;
    private String neighborhood;
    private String complement;
    private String number;

}

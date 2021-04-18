package br.com.customer.api.customer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * The address'contact
 * @author amanda
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDocument {

    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String neighborhood;
    private String complement;
    private String number;

}

package br.com.customer.api.customer.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The customer'contact
 * @author amanda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDocument {

    @NotBlank
    @Size(min = 2, max = 3)
    private String countryCode;

    @NotBlank
    @Size(min = 2, max = 4)
    private String areaCode;

    @NotBlank
    private String phoneNumber;

}

package br.com.customer.api.customer.api.service;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;

/**
 * Define operations that customer can be do
 * @author amanda
 */
public interface CustomerService {

    /**
     *
     * @param customerRequest the basics params for customer
     * @return response for the create operation
     */
    CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest);

}

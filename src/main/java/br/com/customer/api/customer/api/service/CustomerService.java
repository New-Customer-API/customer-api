package br.com.customer.api.customer.api.service;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;

/**
 * Define operations that customer can be do
 * @author amanda
 */
public interface CustomerService {

    /**
     * Service method that validate param's customer and call repository to save
     * @param customerRequest the basics params for customer
     * @return created customer
     */
    CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest) throws InternalServerErrorException;

}

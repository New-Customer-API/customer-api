package br.com.customer.api.customer.api.service;

import br.com.customer.api.customer.api.api.dto.*;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;

/**
 * Define operations that customer can be do
 *
 * @author amanda
 */
public interface CustomerService {

    /**
     * Service method that validate param's customer and call repository to save
     *
     * @param customerRequest the basics params for customer
     * @return created customer
     */
    CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest) throws InternalServerErrorException;

    /**
     * Service method that search all customers by criteria
     *
     * @return list of customers
     * @param customerFilter search criteria
     * @param page list of customers
     */
    ListWrapper<CustomerResponseDTO> getAllCustom(final PageRequestDto page, final CustomerFilter customerFilter);


    /**
     * Service method that search all customers
     *
     * @param page pagination definition
     * @return list of customers
     */
    ListWrapper<CustomerResponseDTO> getAll(final PageRequestDto page);

}

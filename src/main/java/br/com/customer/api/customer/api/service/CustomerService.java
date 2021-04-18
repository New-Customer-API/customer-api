package br.com.customer.api.customer.api.service;

import br.com.customer.api.customer.api.api.dto.*;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;
import br.com.customer.api.customer.api.exception.NotFoundException;
import br.com.customer.api.customer.api.exception.UnprocessableEntityException;

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
     * @throws UnprocessableEntityException
     * @throws InternalServerErrorException
     */
    CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest)
            throws InternalServerErrorException, UnprocessableEntityException;

    /**
     * Service method that search all customers by criteria
     *
     * @param customerFilter search criteria
     * @param page           list of customers
     * @return list of customers
     */
    ListWrapper<CustomerResponseDTO> getAllCustom(final PageRequestDto page, final CustomerFilter customerFilter);

    /**
     * Delete a customer by id
     *
     * @param id customer identifier
     * @return
     */
    void deleteCustomer(final Long id) throws NotFoundException;

    /**
     * Find a customer by id
     *
     * @param id customer identifier
     * @return CustomerResponseDTO
     * @throws NotFoundException
     */
    CustomerResponseDTO findCustomer(final Long id) throws NotFoundException;

    /**
     * Update the customer by id
     *
     * @param id         customer identifier
     * @param requestDTO new customer data
     * @return customer updated
     * @throws NotFoundException
     * @throws UnprocessableEntityException
     */
    CustomerResponseDTO updateCustomer(final Long id, final CustomerRequestDTO requestDTO)
            throws NotFoundException, UnprocessableEntityException;
}

package br.com.customer.api.customer.api.repository;

import br.com.customer.api.customer.api.api.dto.CustomerFilter;
import br.com.customer.api.customer.api.model.CustomerDocument;

import java.util.List;

/**
 * Custom repository to search customers by criteria
 *
 * @author amanda
 */
public interface CustomCustomerRepository {

    /**
     * Search customers by criteria
     *
     * @param customerFilter customer criteria
     * @return list of customer
     */
    List<CustomerDocument> findAllCustomerBy(final CustomerFilter customerFilter);

}

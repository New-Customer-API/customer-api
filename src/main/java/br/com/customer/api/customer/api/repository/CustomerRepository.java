package br.com.customer.api.customer.api.repository;

import br.com.customer.api.customer.api.model.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * This interface is responsible for accessing the database
 * and performing the necessary operations.
 * @author amanda
 */
@Repository
public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {
}

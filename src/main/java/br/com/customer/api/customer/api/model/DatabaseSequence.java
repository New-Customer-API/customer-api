package br.com.customer.api.customer.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Custom sequence
 */
@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private Long seq;
}

package br.com.customer.api.customer.api.model;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The customer collection that will be saved
 *
 * @author amanda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerDocument {

    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";

    @Id
    private Long id;
    private String fullName;
    private String nickName;
    private String document;
    private DocumentType documentType;
    private List<ContactDocument> contact;
    private List<String> email;
    private List<AddressDocument> address;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}

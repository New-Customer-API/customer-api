package br.com.customer.api.customer.api.model;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * The customer collection that will be saved
 * @author amanda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerDocument {

    @Id
    private String id;
    private String fullName;
    private String nickName;
    private String document;
    private DocumentType documentType;
    private List<ContactDocument> contact;
    private List<String> email;
    private List<AddressDocument> address;

}

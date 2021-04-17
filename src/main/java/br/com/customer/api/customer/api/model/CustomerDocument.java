package br.com.customer.api.customer.api.model;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class CustomerDocument implements BaseDocument {

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

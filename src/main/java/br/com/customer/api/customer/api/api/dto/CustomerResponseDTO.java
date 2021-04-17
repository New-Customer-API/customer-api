package br.com.customer.api.customer.api.api.dto;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerResponseDTO {

    private String id;
    private String fullName;
    private String nickName;
    private String document;
    private DocumentType documentType;
    private List<String> email;

}

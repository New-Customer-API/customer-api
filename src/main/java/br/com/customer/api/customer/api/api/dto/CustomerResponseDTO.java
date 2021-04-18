package br.com.customer.api.customer.api.api.dto;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Existing customer
 *
 * @author amanda
 */
@Data
@NoArgsConstructor
public class CustomerResponseDTO {

    private String id;
    private String fullName;
    private String nickName;
    private String document;
    private DocumentType documentType;
    private List<String> email;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}

package br.com.customer.api.customer.api.api.dto;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Customer to be created
 *
 * @author amanda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank
    @Size(min = 10, max = 50)
    private String fullName;

    private String nickName;

    @NotBlank
    @NotNull
    @Size(min = 11, max = 18)
    private String document;

    @NotNull
    private DocumentType documentType;

    private List<@Email String> email;

}

package br.com.customer.api.customer.api.api.dto;

import br.com.customer.api.customer.api.util.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank
    @Size(min = 10, max = 50)
    private String fullName;

    private String nickName;

    @NotBlank
    @Size(min = 11, max = 18)
    private String document;

    @NotNull
    private DocumentType documentType;

    private List<String> email;

}

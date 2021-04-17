package br.com.customer.api.customer.api.mapper;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;
import br.com.customer.api.customer.api.model.CustomerDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDocument dtoToDocument(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO documentToDto(CustomerDocument customerDocument);
}

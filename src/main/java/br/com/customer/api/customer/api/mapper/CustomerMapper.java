package br.com.customer.api.customer.api.mapper;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;
import br.com.customer.api.customer.api.model.CustomerDocument;
import org.mapstruct.IterableMapping;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Map document to dto and dto to document
 *
 * @author amanda
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "address", source = "address")
    @Mapping(target = "contact", source = "contact")
    CustomerDocument dtoToDocument(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO documentToDto(CustomerDocument customerDocument);

    @IterableMapping(qualifiedByName = "documentToDto")
    List<CustomerResponseDTO> documentsToDtos(List<CustomerDocument> customerDocuments);
}

package br.com.customer.api.customer.api.service.impl;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;
import br.com.customer.api.customer.api.mapper.CustomerMapper;
import br.com.customer.api.customer.api.model.CustomerDocument;
import br.com.customer.api.customer.api.repository.CustomerRepository;
import br.com.customer.api.customer.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest) {

        final CustomerDocument customerDocument = customerMapper.dtoToDocument(customerRequest);
        return customerMapper.documentToDto(customerRepository.save(customerDocument));
    }

}

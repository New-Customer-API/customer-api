package br.com.customer.api.customer.api.api.controller;

import br.com.customer.api.customer.api.api.dto.CustomerRequestDTO;
import br.com.customer.api.customer.api.api.dto.CustomerResponseDTO;
import br.com.customer.api.customer.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody final CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

}

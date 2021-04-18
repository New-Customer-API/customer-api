package br.com.customer.api.customer.api.api.controller;

import br.com.customer.api.customer.api.api.dto.*;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;
import br.com.customer.api.customer.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class responsible for receiving requests for customer operations
 *
 * @author amanda
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Create a customer
     *
     * @param customerRequestDTO the basics params for customer
     * @return created customer
     */
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody final CustomerRequestDTO customerRequestDTO) throws InternalServerErrorException {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    /**
     * Find all customer
     *
     * @param page pagination definition
     * @return paginated list of customer
     */
    @GetMapping
    public ResponseEntity<ListWrapper<CustomerResponseDTO>> getAll(final PageRequestDto page) {
        return ResponseEntity.ok(customerService.getAll(page));
    }

    /**
     * Find all customer by criteria
     *
     * @param page pagination definition
     * @return paginated list of customer
     */
    @GetMapping("/searchBy")
    public ResponseEntity<ListWrapper<CustomerResponseDTO>> getAllCustom(final PageRequestDto page,
                                                                         final CustomerFilter customerFilter) {
        return ResponseEntity.ok(customerService.getAllCustom(page, customerFilter));
    }
}

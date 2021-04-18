package br.com.customer.api.customer.api.api.controller;

import br.com.customer.api.customer.api.api.dto.*;
import br.com.customer.api.customer.api.exception.ExceptionResponse;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;
import br.com.customer.api.customer.api.exception.NotFoundException;
import br.com.customer.api.customer.api.exception.UnprocessableEntityException;
import br.com.customer.api.customer.api.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class responsible for receiving requests for customer operations
 *
 * @author amanda
 */
@Api(tags = {"Customer"})
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
     * @throws InternalServerErrorException
     * @throws UnprocessableEntityException
     */
    @ApiOperation(value = "Create a customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer created", response = CustomerResponseDTO.class),
            @ApiResponse(code = 422, message = "Customer with document already exists", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Error", response = ExceptionResponse.class),
    })
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody final CustomerRequestDTO customerRequestDTO)
            throws InternalServerErrorException, UnprocessableEntityException {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    /**
     * Find all customer by criteria
     *
     * @param page pagination definition
     * @return paginated list of customer
     */
    @ApiOperation(value = "Get all customer by criteria")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of customers", response = ListWrapper.class),
            @ApiResponse(code = 500, message = "Internal Error", response = ExceptionResponse.class),
    })
    @GetMapping
    public ResponseEntity<ListWrapper<CustomerResponseDTO>> getAllCustom(final PageRequestDto page,
                                                                         final CustomerFilter customerFilter) {
        return ResponseEntity.ok(customerService.getAllCustom(page, customerFilter));
    }

    /**
     * Delete a customer by id
     *
     * @param id customer identifier
     * @return void
     * @throws NotFoundException
     */
    @ApiOperation(value = "Delete a customer by identifier")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer deleted"),
            @ApiResponse(code = 400, message = "Customer not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Error", response = ExceptionResponse.class),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable final Long id) throws NotFoundException {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Find a customer by id
     *
     * @param id customer identifier
     * @return
     * @throws NotFoundException
     */
    @ApiOperation(value = "Search a customer by identifier")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer founded", response = CustomerResponseDTO.class),
            @ApiResponse(code = 400, message = "Customer not found", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Error", response = ExceptionResponse.class),
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findCustomer(@PathVariable final Long id) throws NotFoundException {
        return ResponseEntity.ok(customerService.findCustomer(id));
    }

    /**
     * Update the customer by id
     *
     * @param id         customer identifier
     * @param requestDTO new customer data
     * @return customer updated
     * @throws NotFoundException
     * @throws UnprocessableEntityException
     */
    @ApiOperation(value = "Update a customer by identifier")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer updated", response = CustomerResponseDTO.class),
            @ApiResponse(code = 400, message = "Customer not found", response = ExceptionResponse.class),
            @ApiResponse(code = 422, message = "Customer with document already exists", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Internal Error", response = ExceptionResponse.class),
    })
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable final Long id,
                                                              @RequestBody final CustomerRequestDTO requestDTO)
            throws NotFoundException, UnprocessableEntityException {
        return ResponseEntity.ok(customerService.updateCustomer(id, requestDTO));
    }

}

package br.com.customer.api.customer.api.service.impl;

import br.com.customer.api.customer.api.api.dto.*;
import br.com.customer.api.customer.api.exception.InternalServerErrorException;
import br.com.customer.api.customer.api.exception.NotFoundException;
import br.com.customer.api.customer.api.exception.UnprocessableEntityException;
import br.com.customer.api.customer.api.mapper.CustomerMapper;
import br.com.customer.api.customer.api.model.CustomerDocument;
import br.com.customer.api.customer.api.model.DatabaseSequence;
import br.com.customer.api.customer.api.repository.CustomerRepository;
import br.com.customer.api.customer.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final MongoOperations mongoOperations;

    @Override
    public CustomerResponseDTO createCustomer(final CustomerRequestDTO customerRequest)
            throws InternalServerErrorException, UnprocessableEntityException {

        verifyAuthenticity(customerRequest);

        final CustomerDocument customerDocument = customerMapper.dtoToDocument(customerRequest);
        customerDocument.setId(generateSequence(CustomerDocument.SEQUENCE_NAME));
        customerDocument.setCreatedAt(LocalDateTime.now());
        try {
            return customerMapper.documentToDto(customerRepository.save(customerDocument));
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public ListWrapper<CustomerResponseDTO> getAllCustom(final PageRequestDto page, final CustomerFilter customerFilter) {
        final List<CustomerDocument> allCustomerBy = customerRepository.findAllCustomerBy(customerFilter);

        final List<CustomerDocument> paginated = allCustomerBy.stream()
                .skip(page.getPage() * page.getSize())
                .limit(page.getSize()).collect(Collectors.toList());

        final PageableResponseDto pageableResponseDto = new PageableResponseDto(
                page.getPage() + 1,
                page.getPage() == 0,
                allCustomerBy.size() == page.getSize() * page.getPage() + paginated.size(),
                paginated.size(),
                Long.valueOf(allCustomerBy.size()),
                allCustomerBy.size() / page.getSize());

        return new ListWrapper(customerMapper.documentsToDtos(paginated), pageableResponseDto);
    }

    @Override
    public ListWrapper<CustomerResponseDTO> getAll(final PageRequestDto page) {
        final Page<CustomerDocument> all = customerRepository.findAll(PageRequest.of(page.getPage(), page.getSize()));
        final PageableResponseDto pageableResponseDto = new PageableResponseDto(
                all.getPageable().getPageNumber(),
                all.isFirst(),
                all.isLast(),
                all.getNumberOfElements(),
                all.getTotalElements(),
                all.getTotalPages());

        return new ListWrapper<>(customerMapper.documentsToDtos(all.getContent()),
                pageableResponseDto);
    }

    @Override
    public CustomerResponseDTO findCustomer(final Long id) throws NotFoundException {

        final Optional<CustomerDocument> byId = customerRepository.findById(id);

        if (!byId.isPresent()) {
            throw new NotFoundException("Customer not found!");
        }
        return customerMapper.documentToDto(byId.get());
    }

    @Override
    public void deleteCustomer(final Long id) throws NotFoundException {

        final CustomerResponseDTO customer = findCustomer(id);
        customerRepository.deleteById(customer.getId());
    }

    @Override
    public CustomerResponseDTO updateCustomer(final Long id, final CustomerRequestDTO requestDTO)
            throws NotFoundException, UnprocessableEntityException {

        final CustomerResponseDTO customer = findCustomer(id);
        verifyAuthenticity(requestDTO);

        final CustomerDocument customerDocument = customerMapper.dtoToDocument(requestDTO);
        customerDocument.setId(customer.getId());
        customerDocument.setUpdateAt(LocalDateTime.now());
        return customerMapper.documentToDto(customerRepository.save(customerDocument));
    }

    private void verifyAuthenticity(final CustomerRequestDTO customerRequest)
            throws UnprocessableEntityException {

        final Optional<CustomerDocument> byDocumentAndDocumentType = customerRepository
                .findByDocumentAndDocumentType(customerRequest.getDocument(),
                        customerRequest.getDocumentType());

        if (byDocumentAndDocumentType.isPresent()) {
            throw new UnprocessableEntityException("Customer with document already exists!");
        }
    }

    private Long generateSequence(final String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}

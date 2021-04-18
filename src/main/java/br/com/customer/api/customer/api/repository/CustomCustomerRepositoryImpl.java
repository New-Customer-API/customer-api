package br.com.customer.api.customer.api.repository;

import br.com.customer.api.customer.api.api.dto.CustomerFilter;
import br.com.customer.api.customer.api.model.CustomerDocument;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<CustomerDocument> findAllCustomerBy(final CustomerFilter customerFilter) {

        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (Objects.nonNull(customerFilter)) {

            if (StringUtils.isNotEmpty(customerFilter.getAreaCode())) {
                criteria.add(Criteria.where("areaCode").is(customerFilter.getAreaCode()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getCity())) {
                criteria.add(Criteria.where("city").is(customerFilter.getCity()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getComplement())) {
                criteria.add(Criteria.where("complement").is(customerFilter.getComplement()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getCountry())) {
                criteria.add(Criteria.where("country").is(customerFilter.getCountry()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getCountryCode())) {
                criteria.add(Criteria.where("countryCode").is(customerFilter.getCountryCode()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getDocumentType())) {
                criteria.add(Criteria.where("documentType").is(customerFilter.getDocumentType()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getDocument())) {
                criteria.add(Criteria.where("document").is(customerFilter.getDocument()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getEmail())) {
                criteria.add(Criteria.where("email").is(customerFilter.getEmail()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getFullName())) {
                criteria.add(Criteria.where("fullName").is(customerFilter.getFullName()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getNeighborhood())) {
                criteria.add(Criteria.where("neighborhood").is(customerFilter.getNeighborhood()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getNickName())) {
                criteria.add(Criteria.where("nickName").is(customerFilter.getNickName()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getNumber())) {
                criteria.add(Criteria.where("number").is(customerFilter.getNumber()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getPhoneNumber())) {
                criteria.add(Criteria.where("phoneNumber").is(customerFilter.getPhoneNumber()));
            }

            if (StringUtils.isNotEmpty(customerFilter.getState())) {
                criteria.add(Criteria.where("state").is(customerFilter.getState()));
            }

        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, CustomerDocument.class);
    }
}


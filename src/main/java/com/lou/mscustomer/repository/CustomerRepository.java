package com.lou.mscustomer.repository;

import com.lou.mscustomer.models.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    Mono<Customer> findByIdentityCard_NumberDocument(Integer number);

}

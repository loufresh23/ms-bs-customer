package com.lou.mscustomer.services;

import com.lou.mscustomer.models.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Mono<Customer> findByIdentityNumber(Integer identityNumber);

    Mono<Integer> save(Customer customer);

}

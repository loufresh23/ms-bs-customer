package com.lou.mscustomer.services;

import com.lou.mscustomer.models.Customer;
import com.lou.mscustomer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll()
                .doOnComplete(() -> log.info("Success findAll customer"))
                .doOnError(err -> log.error("Error findAll customer"));
    }

    @Override
    public Mono<Customer> findByIdentityNumber(Integer identityNumber) {
        return customerRepository.findByIdentityCard_NumberDocument(identityNumber)
                .doOnSuccess(msg -> log.info("Success findByIdentityNumber customer"))
                .doOnError(err -> log.error("Error findByIdentityNumber customer"));
    }

    @Override
    public Mono<Integer> save(Customer customer) {
        return customerRepository.save(customer)
                .map(c -> c.getIdentityCard().getNumberDocument())
                .doOnSuccess(msg -> log.info("Success save customer " + msg))
                .doOnError(err -> log.error("Error save customer"));
    }
}

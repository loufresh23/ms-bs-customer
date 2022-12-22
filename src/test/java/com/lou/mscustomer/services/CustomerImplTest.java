package com.lou.mscustomer.services;

import com.lou.mscustomer.models.Customer;
import com.lou.mscustomer.models.IdentityCard;
import com.lou.mscustomer.models.TypeDocument;
import com.lou.mscustomer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class CustomerImplTest {

    @InjectMocks
    private CustomerImpl service;

    @Mock
    private CustomerRepository repository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setName("Luis");
        customer.setLastname("Ascencion");
        customer.setIdentityCard(new IdentityCard(TypeDocument.DNI,71380976));
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(Flux.just(customer));
        StepVerifier.create(service.findAll())
                .expectNextMatches(c -> Objects.equals(c.getLastname(),"Ascencion"))
                .expectComplete()
                .verify();
    }

    @Test
    void findByIdentityNumber() {
        when(repository.findByIdentityCard_NumberDocument(anyInt()))
                .thenReturn(Mono.just(customer));
        StepVerifier.create(service.findByIdentityNumber(customer.getIdentityCard().getNumberDocument()))
                .expectNextMatches(c -> Objects.equals(c.getLastname(),"Ascencion"))
                .expectComplete()
                .verify();
    }

    @Test
    void save() {
        when(repository.save(any(Customer.class))).thenReturn(Mono.just(customer));
        StepVerifier.create(service.save(customer))
                .expectNextMatches(id -> Objects.equals(id,71380976))
                .expectComplete()
                .verify();
    }
}
package com.lou.mscustomer.controllers;

import com.lou.mscustomer.models.Customer;
import com.lou.mscustomer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer/")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("list")
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("findByIdentityNumber")
    public Mono<Customer> findById(@RequestParam Integer identityNumber) {
        return customerService.findByIdentityNumber(identityNumber);
    }

    @PostMapping("save")
    public Mono<Integer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}

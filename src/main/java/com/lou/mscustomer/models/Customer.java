package com.lou.mscustomer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @MongoId
    private String       uuid;
    private String       name;
    private String       lastname;
    private IdentityCard identityCard;
    private TypeCustomer typeCustomer;
}

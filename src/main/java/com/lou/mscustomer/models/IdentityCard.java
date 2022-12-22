package com.lou.mscustomer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdentityCard {

    private TypeDocument typeDocument;
    private Integer      numberDocument;
}


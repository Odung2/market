package com.example.market.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PurchaseRequest {

    @NotNull
    private Long orderer;

    @NotNull
    private List<Long> productsId;

}

package com.example.market.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PurchaseRequest {

    @NotBlank
    private long orderer;

    @NotNull
    private List<Map<Long, Long>> products;

}

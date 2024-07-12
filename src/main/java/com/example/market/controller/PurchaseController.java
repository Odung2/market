package com.example.market.controller;

import com.example.market.domain.entity.Purchase;
import com.example.market.model.PurchaseRequest;
import com.example.market.service.PurchaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping("/{purchaseId}")
    public ResponseEntity<Purchase> selectProduct(@PathVariable Long purchaseId){
        return ResponseEntity.ok(purchaseService.getPurchase(purchaseId));
    }

    @PostMapping
    public ResponseEntity<Long> insertProduct(@RequestBody @Valid PurchaseRequest purchaseRequest) {
        return ResponseEntity.ok(purchaseService.savePurchase(purchaseRequest));
    }

    @PutMapping("/{purchaseId}")
    public ResponseEntity<Purchase> updateProduct(
            @PathVariable Long purchaseId) {
        return ResponseEntity.ok(purchaseService.cancelPurchase(purchaseId));
    }
}

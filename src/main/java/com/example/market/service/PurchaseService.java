package com.example.market.service;

import com.example.market.domain.entity.Member;
import com.example.market.domain.entity.Product;
import com.example.market.domain.entity.Purchase;
import com.example.market.domain.repository.MemberRepository;
import com.example.market.domain.repository.ProductRepository;
import com.example.market.domain.repository.PurchaseRepository;
import com.example.market.model.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    public Long savePurchase(PurchaseRequest purchaseRequest) {
        Member orderer = memberRepository.findById(purchaseRequest.getOrderer()).orElseThrow();

        List<Product> products = purchaseRequest.getProductsId().stream()
                .map(productId -> productRepository.findById(productId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId)))
                .collect(Collectors.toList());

        return purchaseRepository.save(new Purchase().setRelation(orderer, products)).getId();
    }
    public Purchase getPurchase(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).orElseThrow();
    }

    public Purchase cancelPurchase(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).orElseThrow().cancelPurchase();
    }


}

package com.example.market.service;

import com.example.market.domain.entity.Product;
import com.example.market.domain.repository.ProductRepository;
import com.example.market.model.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long saveProduct(ProductRequest productRequest) {
        return productRepository.save(
                Product.builder()
                        .name(productRequest.getName())
                        .price(productRequest.getPrice())
                        .build()
        ).getId();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product updateProduct(Long productId, ProductRequest productRequest) {
        Product product = productRepository.findById(productId).orElseThrow();
        return product.updateProduct(productRequest);
    }

}

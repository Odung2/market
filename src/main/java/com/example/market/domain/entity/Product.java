package com.example.market.domain.entity;

import com.example.market.model.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
@Builder
public class Product extends JpaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long price;

    @OneToMany(mappedBy = "product")
    private List<PurchaseProduct> purchaseProducts;

    public Product updateProduct(ProductRequest productRequest) {
        if (productRequest.getName() != null) {
            this.name = productRequest.getName();
        }
        if (productRequest.getPrice() != null) {
            this.price = productRequest.getPrice();
        }
        return this;
    }
}

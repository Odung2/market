package com.example.market.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "purchase_product")
public class PurchaseProduct extends JpaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id", nullable = false)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public PurchaseProduct(Purchase purchase, Product product) {
        this.purchase = purchase;
        this.product = product;
        purchase.getPurchaseProducts().add(this);
        product.getPurchaseProducts().add(this);
    }
}

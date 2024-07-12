package com.example.market.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase")
@Builder
public class Purchase extends JpaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id")
    private Member orderer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseProduct> purchaseProducts = new ArrayList<>();

    private boolean isCanceled;

    public Purchase setRelation(Member orderer, List<Product> products) {
        this.orderer = orderer;
        for (Product product : products) {
            PurchaseProduct purchaseProduct = new PurchaseProduct(this, product);
            this.purchaseProducts.add(purchaseProduct);
        }
        this.orderer.getOrders().add(this);
        return this;
    }

    public Purchase cancelPurchase() {
        this.isCanceled = true;
        return this;
    }
}

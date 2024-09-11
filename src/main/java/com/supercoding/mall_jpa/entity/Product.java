package com.supercoding.mall_jpa.entity;

import com.supercoding.mall_jpa.enums.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Builder
    public Product(String productName, int price, int quantity,Category category){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        calculateTotalPrice();
    }
    private void calculateTotalPrice() {
        this.totalPrice = this.price * this.quantity;
    }

}

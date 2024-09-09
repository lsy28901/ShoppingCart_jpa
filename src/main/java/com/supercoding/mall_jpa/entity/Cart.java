package com.supercoding.mall_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart") //연관관계의 주인은 User (외래키를 관리하는 쪽)
    private User user;

    @OneToMany(mappedBy = "cart") //일대다에서 연관관계의 주인은 '다' 쪽이다.
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        if (product != null){
            product.setCart(this);
            productList.add(product);
        }
    }
}

package com.supercoding.mall_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Cart {

    @Id
    private Long id;

    @OneToOne
    @MapsId  // Cart의 ID를 User의 ID와 동일하게 설정
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "cart") //일대다에서 연관관계의 주인은 '다' 쪽이다.
    private List<Product> productList = new ArrayList<>();

    public Cart(User user){
        this.user = user;
    }

    public void addProduct(Product product){
        if (product != null){
            product.setCart(this);
            productList.add(product);
        }
    }

}

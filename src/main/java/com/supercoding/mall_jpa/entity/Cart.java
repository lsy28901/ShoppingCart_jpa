package com.supercoding.mall_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @MapsId  // Cart 의 ID를 User 의 ID와 동일하게 설정
    @JoinColumn(name = "id")
    @JsonIgnore // JSON 직렬화에서 이 필드를 제외하여 순환 참조 방지
    private User user;

    @OneToMany(mappedBy = "cart") //일대다에서 연관관계의 주인은 '다' 쪽이다.
    private List<Product> productList = new ArrayList<>();

    //양방향 연관관계 관계성 주입
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

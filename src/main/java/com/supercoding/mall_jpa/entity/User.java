package com.supercoding.mall_jpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@ToString(exclude = {"id","cart"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 50)
    private String password;

    private String address;

    private String phoneNum;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Cart cart;

    @Builder
    public User(String userId,String name,String password, String address, String phoneNum){
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;
        this.cart = new Cart(this);
    }

    //MapStruct 매핑을 위한 생성자
    public User(String userId, String name, String phoneNum) {
        this.userId = userId;
        this.name = name;
        this.phoneNum = phoneNum;
    }
}

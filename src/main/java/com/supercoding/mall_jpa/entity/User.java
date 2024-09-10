package com.supercoding.mall_jpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
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



}

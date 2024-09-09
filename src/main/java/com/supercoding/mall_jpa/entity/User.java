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
    private String userId;
    private String name;
    private String password;
    private String address;
    private String phoneNum;

    @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Cart cart;

    @Builder
    public User(String userId,String name,String password, String address, String phoneNum,Cart cart){
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;
        this.cart = cart;
    }

}

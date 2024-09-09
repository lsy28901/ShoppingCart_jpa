package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}

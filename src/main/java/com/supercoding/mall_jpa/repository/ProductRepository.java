package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

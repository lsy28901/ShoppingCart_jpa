package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

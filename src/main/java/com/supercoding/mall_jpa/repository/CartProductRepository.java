package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct,Long> {

    //CartProduct 는 Cart, Product 간의 다대다 연관관계를 도우는 매핑엔티티임
    //따라서 cp 안의 cart 와 product 를 조인함
    //CartProduct 안의 Cart 의 id 와 요청값인 id(유저의 id 이면서 카트의 id)가 같아야함
    //CartProduct 객체는 Product 정보를 갖고있음. 갖고있는 프로덕트 들의 price 기준으로 내림차순 정렬함.
    @Query("select cp from CartProduct cp " +
            "join cp.cart c " +
            "join cp.product p " +
            "where c.id = :id " +
            "ORDER BY p.price DESC ")
    List<CartProduct> findListByIdOrderByPriceDesc(Long id);
}

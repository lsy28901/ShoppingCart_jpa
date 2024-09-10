package com.supercoding.mall_jpa.entity;

import com.supercoding.mall_jpa.enums.Category;
import com.supercoding.mall_jpa.repository.CartRepository;
import com.supercoding.mall_jpa.repository.ProductRepository;
import com.supercoding.mall_jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Slf4j
public class EntityTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void userEntityTest(){


        User user =  User.builder()
                .userId("lsy1234")
                .name("이수연")
                .password("1234")
                .address("경기도")
                .phoneNum("010-1234-1234")
                .build();

        userRepository.save(user);

        log.info("user ID = {}",user.getId());
        log.info("cart? = {}",user.getCart().getUser().getName());

        Product product1 = Product.builder()
                .productName("신라면")
                .price(1000)
                .quantity(5)
                .category(Category.FOOD).build();
        productRepository.save(product1);

        log.info("product ID = {}",product1.getId());
        log.info("product TotalPrice = {}",product1.getTotalPrice());

        Cart foundCart = cartRepository.findById(user.getCart().getId()).orElseThrow();
        foundCart.addProduct(product1);
        log.info("foundCarts ={}",foundCart.getProductList().get(0).getProductName());

        assertThat(user.getId()).isNotNull();
        assertThat(user.getCart()).isNotNull();
    }


}

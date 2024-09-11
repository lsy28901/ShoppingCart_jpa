package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.dto.mapper.CartMapper;
import com.supercoding.mall_jpa.dto.mapper.ProductMapper;
import com.supercoding.mall_jpa.entity.Cart;
import com.supercoding.mall_jpa.entity.CartProduct;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.exceptions.NotFoundException;
import com.supercoding.mall_jpa.repository.CartProductRepository;
import com.supercoding.mall_jpa.repository.CartRepository;
import com.supercoding.mall_jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public void addToCart(long id,long product_id){
        Cart cart = checkCartNotFoundException(id);
        Product product = checkProductNotFoundException(product_id);
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    public List<ViewCartDTO> viewMyCart(long id){
        Cart cart = cartRepository.findById(id)
                .orElseThrow(()->new NotFoundException("장바구니를 찾을 수 없습니다"));

        List<Product> productList = cart.getProductList();
        return productList.stream()
                .map(CartMapper.INSTANCE::productToViewCartDTO)
                .toList();
    }

    public void deleteToCart(long id,long product_id){
        Cart cart = checkCartNotFoundException(id);
        Product product = checkProductNotFoundException(product_id);
        cart.deleteProduct(product);
    }

    public Product checkProductNotFoundException(long product_id){
        return productRepository.findById(product_id)
                .orElseThrow(()->new NotFoundException("해당 상품을 찾을 수 없습니다."));
    }
    public Cart checkCartNotFoundException(long id){
        return cartRepository.findById(id)
                .orElseThrow(()->new NotFoundException("장바구니를 찾을 수 없습니다"));
    }

}

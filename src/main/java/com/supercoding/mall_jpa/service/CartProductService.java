package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.dto.mapper.CartMapper;
import com.supercoding.mall_jpa.entity.CartProduct;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.repository.CartProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartProductService {
    private final CartProductRepository cartProductRepository;

    public List<ViewCartDTO> viewMyCartSortByPriceDesc(long id){
        List<CartProduct> cartProductList = cartProductRepository.findListByIdOrderByPriceDesc(id);
        return cartProductList.stream()
                .map(CartMapper.INSTANCE::CartProductListToViewCartDTO).toList();
    }

    public Page<ViewCartDTO> viewMyCartPageSorted(long id, Pageable pageable){
        Page<Product> cartProducts = cartProductRepository.findPageByIdSorted(id,pageable);
        return cartProducts.map(CartMapper.INSTANCE::CartProductListToViewCartDTO);
    }
}

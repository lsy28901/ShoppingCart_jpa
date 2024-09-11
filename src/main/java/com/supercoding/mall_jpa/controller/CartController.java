package com.supercoding.mall_jpa.controller;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.service.CartProductService;
import com.supercoding.mall_jpa.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartProductService cartProductService;

    @PostMapping("/add")
    public String addProductToCart(@RequestParam long id, @RequestParam long product_id){
        cartService.addToCart(id,product_id);
        return "장바구니에 담기 성공";
    }

    @GetMapping("/view/all")
    public List<ViewCartDTO> viewMyCart(@RequestParam long id){
        return cartService.viewMyCart(id);
    }

    @GetMapping("/view/sort")
    public List<ViewCartDTO> viewMyCartSorted(@RequestParam long id, @RequestParam String sorted){
        List<ViewCartDTO> myCartList = null;
        if (sorted.equals("price")){
            myCartList = cartProductService.viewMyCartSortByPriceDesc(id);
        }

        return myCartList;
    }
}

package com.supercoding.mall_jpa.controller;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.enums.Category;
import com.supercoding.mall_jpa.service.CartProductService;
import com.supercoding.mall_jpa.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/view/paging")
    public Page<ViewCartDTO> viewMyCartPageSorted(@RequestParam long id,Pageable pageable){
        return cartProductService.viewMyCartPageSorted(id,pageable);
    }

    @GetMapping("/view/filter/name")
    public Page<ViewCartDTO> viewMyCartPageFilteredByName(@RequestParam long id
            ,Pageable pageable , @RequestParam String keyword){
        return cartProductService.viewMyCartFilteredByName(id, pageable, keyword);
    }

    @GetMapping("/view/filter/category")
    public Page<ViewCartDTO> viewMyCartPageFilteredByCategory(@RequestParam long id
            ,Pageable pageable, @RequestParam Category category){
        return cartProductService.viewMyCartFilteredByCategory(id, pageable, category);
    }

    @DeleteMapping("/delete")
    public String deleteProductToCart(@RequestParam long id,@RequestParam long product_id){
        cartService.deleteToCart(id,product_id);
        return "장바구니에서 삭제 성공";
    }
}

package com.supercoding.mall_jpa.controller;

import com.supercoding.mall_jpa.dto.product.AddProductDTO;
import com.supercoding.mall_jpa.dto.product.ViewProductListDTO;
import com.supercoding.mall_jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody AddProductDTO addProductDTO){
        productService.addProduct(addProductDTO);
        return "상품 등록에 성공했습니다.";
    }

    @GetMapping("/view/all")
    public List<ViewProductListDTO> viewAllProducts(){
        return productService.viewAllProducts();
    }
}

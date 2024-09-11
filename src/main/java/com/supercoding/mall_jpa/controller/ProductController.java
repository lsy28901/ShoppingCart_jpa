package com.supercoding.mall_jpa.controller;

import com.supercoding.mall_jpa.dto.product.AddProductDTO;
import com.supercoding.mall_jpa.dto.product.ViewProductListDTO;
import com.supercoding.mall_jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    @GetMapping("/view/paging")
    public Page<ViewProductListDTO> viewAllProductsPaging(Pageable pageable){
        return productService.viewAllProductsPaging(pageable);
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam long id){
        productService.deleteProduct(id);
        return "상품을 성공적으로 삭제했습니다.";
    }
}

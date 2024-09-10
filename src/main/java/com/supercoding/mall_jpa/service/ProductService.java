package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.mapper.ProductMapper;
import com.supercoding.mall_jpa.dto.product.AddProductDTO;
import com.supercoding.mall_jpa.dto.product.ViewProductListDTO;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(AddProductDTO addProductDTO){
        Product product = Product.builder()
                .productName(addProductDTO.getProductName())
                .price(addProductDTO.getPrice())
                .quantity(addProductDTO.getQuantity())
                .category(addProductDTO.getCategory()).build();
        productRepository.save(product);
    }

    public List<ViewProductListDTO> viewAllProducts(){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductMapper.INSTANCE::productToViewProductListDTO)
                .toList();
    }
}

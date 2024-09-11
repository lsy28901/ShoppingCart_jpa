package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.mapper.ProductMapper;
import com.supercoding.mall_jpa.dto.product.AddProductDTO;
import com.supercoding.mall_jpa.dto.product.ViewProductListDTO;
import com.supercoding.mall_jpa.entity.Product;
import com.supercoding.mall_jpa.exceptions.NotFoundException;
import com.supercoding.mall_jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(AddProductDTO addProductDTO){
        Product product = ProductMapper.INSTANCE.addProductDtoToProduct(addProductDTO);
        productRepository.save(product);
    }

    public List<ViewProductListDTO> viewAllProducts(){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductMapper.INSTANCE::productToViewProductListDTO)
                .toList();
    }
    public Page<ViewProductListDTO> viewAllProductsPaging(Pageable pageable){
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(ProductMapper.INSTANCE::productToViewProductListDTO);
    }

    public void deleteProduct(long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.delete(optionalProduct.get());
        }else {
            throw new NotFoundException("상품 삭제에 실패했습니다");
        }
    }
}

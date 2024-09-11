package com.supercoding.mall_jpa.dto.mapper;

import com.supercoding.mall_jpa.dto.product.AddProductDTO;
import com.supercoding.mall_jpa.dto.product.ViewProductListDTO;
import com.supercoding.mall_jpa.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "productName",target = "productName")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantity",target = "quantity")
    @Mapping(target = "category",expression = "java(p.getCategory().getName())")
    @Mapping(target = "totalPrice",expression = "java(p.getPrice() * p.getQuantity())")
    ViewProductListDTO productToViewProductListDTO(Product p);

    Product addProductDtoToProduct(AddProductDTO dto);
}

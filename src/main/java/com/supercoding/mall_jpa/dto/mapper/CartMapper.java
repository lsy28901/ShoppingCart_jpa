package com.supercoding.mall_jpa.dto.mapper;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.entity.Cart;
import com.supercoding.mall_jpa.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(source = "productName",target = "name")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantity",target = "quantity")
    @Mapping(target = "category",expression = "java(p.getCategory().getName())")
    @Mapping(target = "totalPrice",expression = "java(p.getPrice() * p.getQuantity())")
    ViewCartDTO productToViewCartDTO(Product p);
}

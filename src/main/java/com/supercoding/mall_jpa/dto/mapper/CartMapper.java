package com.supercoding.mall_jpa.dto.mapper;

import com.supercoding.mall_jpa.dto.cart.ViewCartDTO;
import com.supercoding.mall_jpa.entity.Cart;
import com.supercoding.mall_jpa.entity.CartProduct;
import com.supercoding.mall_jpa.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(source = "productName",target = "name")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "quantity",target = "quantity")
    @Mapping(target = "category",expression = "java(p.getCategory().getName())")
    @Mapping(target = "totalPrice",expression = "java(p.getPrice() * p.getQuantity())")
    ViewCartDTO productToViewCartDTO(Product p);

    @Mapping(target = "name",expression = "java(cp.getProduct().getProductName())")
    @Mapping(target = "price",expression = "java(cp.getProduct().getPrice())")
    @Mapping(target = "quantity",expression = "java(cp.getProduct().getQuantity())")
    @Mapping(target = "category",expression = "java(cp.getProduct().getCategory().getName())")
    @Mapping(target = "totalPrice",expression = "java(cp.getProduct().getPrice() * cp.getProduct().getQuantity())")
    ViewCartDTO CartProductListToViewCartDTO(CartProduct cp);

    @Mapping(target = "name",expression = "java(p.getProductName())")
    @Mapping(target = "price",expression = "java(p.getPrice())")
    @Mapping(target = "quantity",expression = "java(p.getQuantity())")
    @Mapping(target = "category",expression = "java(p.getCategory().getName())")
    @Mapping(target = "totalPrice",expression = "java(p.getPrice() * p.getQuantity())")
    ViewCartDTO CartProductListToViewCartDTO(Product p);
}

package com.supercoding.mall_jpa.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ViewProductListDTO {
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;
    private String category;
}

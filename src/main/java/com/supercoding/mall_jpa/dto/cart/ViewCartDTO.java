package com.supercoding.mall_jpa.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ViewCartDTO {
    private String name;
    private int price;
    private int quantity;
    private int totalPrice;
    private String category;

}

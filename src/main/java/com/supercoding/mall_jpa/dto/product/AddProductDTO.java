package com.supercoding.mall_jpa.dto.product;

import com.supercoding.mall_jpa.enums.Category;
import lombok.Getter;

@Getter
public class AddProductDTO {
    private String productName;
    private int price;
    private int quantity;
    private Category category;
}

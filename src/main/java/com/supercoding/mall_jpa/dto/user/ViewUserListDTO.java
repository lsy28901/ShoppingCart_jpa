package com.supercoding.mall_jpa.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class ViewUserListDTO {
    private String userId;
    private String name;
    private String phoneNum;

}

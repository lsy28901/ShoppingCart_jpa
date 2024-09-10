package com.supercoding.mall_jpa.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpDTO {
    private String userId;
    private String name;
    private String password;
    private String address;
    private String phoneNum;
}

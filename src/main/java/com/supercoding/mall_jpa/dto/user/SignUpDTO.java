package com.supercoding.mall_jpa.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class SignUpDTO {
    private String userId;
    private String name;
    private String password;
    private String address;
    private String phoneNum;
}

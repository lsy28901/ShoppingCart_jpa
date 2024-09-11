package com.supercoding.mall_jpa.dto.mapper;

import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserMapperTest {

    //순수 유닛 테스트 -> 의존성없는 메소드. 외부 라이브러리 기능 테스트
    @DisplayName("유저 정보를 보여주기 위한 DTO로 맵핑해주는 것 테스트")
    @Test
    void userToViewUserListDTO() {
        //given
        User user = User.builder()
                .userId("test1234")
                .password("1234")
                .name("tester")
                .address("서울")
                .phoneNum("010-1234-1234").build();

        //when
        ViewUserListDTO dto = UserMapper.INSTANCE.userToViewUserListDTO(user);

        //then
        Assertions.assertEquals(user.getUserId(),dto.getUserId());
        assertEquals(user.getName(),dto.getName());
    }
}
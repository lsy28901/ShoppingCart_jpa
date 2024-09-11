package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //슬라이스 테스트 -> 레포지토리 레이어(데이터 접근 계층), JPA 사용
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class UserRepositoryTest {
    //레포지토리에 해당하는 빈만 사용할 수 있음
    @Autowired
    private UserRepository userRepository;

    @DisplayName("유저아이디로 유저 찾기 테스트")
    @Test
    void findByUserId() {
        //given
        String userID = "lsy1234";
        //when
        User findUser = userRepository.findByUserId(userID);
        //then
        log.info("find User Name = {}",findUser.getName());
        //이후 로그의 값과 실제 DB와 비교

    }
}
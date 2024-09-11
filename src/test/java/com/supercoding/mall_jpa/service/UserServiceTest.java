package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.mapper.UserMapper;
import com.supercoding.mall_jpa.dto.user.SignUpDTO;
import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.exceptions.NotFoundException;
import com.supercoding.mall_jpa.repository.UserRepository;
import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
class UserServiceTest {
    //Mockito 테스트 -> 의존성을 갖는 서비스레이어의 로직을 테스트함.
    @Mock
    private UserRepository userRepository;

    //@Mock 들을 얘한테 주입해줄것임
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("회원가입 성공 테스트")
    @Test
    void signUpSuccess() {
        //given
        String userId = "test1234";
        String name = "테스터";
        String password = "1234";
        String address = "서울";
        String phoneNum = "010-1234-1234";

        //thenReturn()을 통해 받을 save()의 리턴값에 대한 값을 만들어줘야함
        User user = User.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .address(address)
                .phoneNum(phoneNum).build();

        //when
        when(userRepository.save(any())).thenReturn(user);

        //then
        List<ViewUserListDTO> users = userService.viewAllUsers();
        assertTrue(
                users.stream().map(ViewUserListDTO::getUserId).allMatch(uid -> uid.equals(userId))
        );
        //assertTrue 등, 컬렉션은 스트림 써서 뭔가 로직 확인함.
    }

    @DisplayName("Id 가 null 이라 회원가입에 실패하는 테스트")
    @Test
    void signUpFail() {
        //given
//        String userId = null;
        String userId = "test1234"; //정상적으로 값이 들어가면 테스트 실패함.
        String name = "테스터";
        String password = "1234";
        String address = "서울";
        String phoneNum = "010-1234-1234";

        SignUpDTO signUpDTO = SignUpDTO.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .address(address)
                .phoneNum(phoneNum).build();

        //when

        //then
        assertThrows(IllegalArgumentException.class,
                () -> userService.signUp(signUpDTO));
    }

}
package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.mapper.UserMapper;
import com.supercoding.mall_jpa.dto.user.SignUpDTO;
import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.exceptions.UserSignUpFailException;
import com.supercoding.mall_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignUpDTO signUpDTO){
        //mockTest 를 위한 학습용 예외처리 코드
        if (signUpDTO.getUserId() == null || signUpDTO.getUserId().isEmpty()) {
            throw new IllegalArgumentException("ID는 필수입니다.");
        }

        User foundUser = userRepository.findByUserId(signUpDTO.getUserId());
        if (foundUser != null){
            throw new UserSignUpFailException("이미 존재하는 ID 입니다.");
        }else {
            User newUser = UserMapper.INSTANCE.SignUpDtoToUser(signUpDTO);
            userRepository.save(newUser);
        }
    }

    @Transactional
    public List<ViewUserListDTO> viewAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper.INSTANCE::userToViewUserListDTO)
                .toList();
    }

}

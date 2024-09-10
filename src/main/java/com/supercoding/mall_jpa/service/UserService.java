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

        User newUser = User.builder()
                .userId(signUpDTO.getUserId())
                .password(signUpDTO.getPassword())
                .name(signUpDTO.getName())
                .address(signUpDTO.getAddress())
                .phoneNum(signUpDTO.getPhoneNum())
                .build();
        User foundUser = userRepository.findByUserId(newUser.getUserId());
        if (foundUser != null){
            throw new UserSignUpFailException("이미 존재하는 ID 입니다.");
        }else {
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

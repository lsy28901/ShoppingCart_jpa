package com.supercoding.mall_jpa.service;

import com.supercoding.mall_jpa.dto.mapper.UserMapper;
import com.supercoding.mall_jpa.dto.user.SignUpDTO;
import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.Cart;
import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.repository.CartRepository;
import com.supercoding.mall_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(SignUpDTO signUpDTO){

        User newUser = User.builder()
                .userId(signUpDTO.getUserId())
                .password(signUpDTO.getPassword())
                .name(signUpDTO.getName())
                .address(signUpDTO.getAddress())
                .phoneNum(signUpDTO.getPhoneNum())
                .build();
        return userRepository.save(newUser);
    }

    @Transactional
    public List<ViewUserListDTO> viewAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper.INSTANCE::userToViewUserListDTO)
                .toList();
    }

}

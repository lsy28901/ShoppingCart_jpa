package com.supercoding.mall_jpa.controller;

import com.supercoding.mall_jpa.dto.user.SignUpDTO;
import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.User;
import com.supercoding.mall_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpDTO signUpDTO){
        userService.signUp(signUpDTO);
    }

    @GetMapping("/view/all")
    public List<ViewUserListDTO> viewAllUsers(){
        return userService.viewAllUsers();
    }
}

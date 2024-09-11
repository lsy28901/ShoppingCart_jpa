package com.supercoding.mall_jpa.dto.mapper;

import com.supercoding.mall_jpa.dto.user.SignUpDTO;
import com.supercoding.mall_jpa.dto.user.ViewUserListDTO;
import com.supercoding.mall_jpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId",target = "userId")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "phoneNum",target = "phoneNum")
    ViewUserListDTO userToViewUserListDTO(User user);

    User SignUpDtoToUser(SignUpDTO signUpDTO);
}

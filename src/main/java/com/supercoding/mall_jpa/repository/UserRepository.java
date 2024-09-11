package com.supercoding.mall_jpa.repository;

import com.supercoding.mall_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId(String userId);
}

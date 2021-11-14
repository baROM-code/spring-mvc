package com.geekbrains.ru.springmvcdemo.service;

import com.geekbrains.ru.springmvcdemo.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserEntity findByUsername(String username);

    UserEntity save(UserEntity user);

    Page<UserEntity> findAllByPage(Pageable pageRequest);

    void setEnable(Long userId, Boolean enable);

}

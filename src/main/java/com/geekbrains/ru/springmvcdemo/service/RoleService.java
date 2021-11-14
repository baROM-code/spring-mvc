package com.geekbrains.ru.springmvcdemo.service;

import com.geekbrains.ru.springmvcdemo.domain.RoleEntity;

public interface RoleService {

    RoleEntity findByName(String name);

}

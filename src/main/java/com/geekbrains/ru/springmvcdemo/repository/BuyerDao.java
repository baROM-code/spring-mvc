package com.geekbrains.ru.springmvcdemo.repository;

import com.geekbrains.ru.springmvcdemo.domain.Buyer;

public interface BuyerDao {

    Buyer get(long id);

}

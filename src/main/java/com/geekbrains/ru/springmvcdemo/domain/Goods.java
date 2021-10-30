package com.geekbrains.ru.springmvcdemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
}

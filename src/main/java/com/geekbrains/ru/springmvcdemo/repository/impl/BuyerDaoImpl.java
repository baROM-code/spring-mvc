package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.domain.Buyer;
import com.geekbrains.ru.springmvcdemo.repository.BuyerDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BuyerDaoImpl implements BuyerDao {

    public static SessionFactory sessionfactory;

    private static void init() {
        sessionfactory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @Override
    public Buyer get(long id) {
        try {
            init();
            Buyer buyer = sessionfactory.openSession().get(Buyer.class, id);
            return buyer;
        } finally {
            sessionfactory.close();
        }

    }
}

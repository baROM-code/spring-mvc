package com.geekbrains.ru.springmvcdemo;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringMvcDemo2Application {

    public static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/magaz", "postgres", "root")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();

        SpringApplication.run(SpringMvcDemo2Application.class, args);
    }

    /*

    spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: dbc:postgresql://localhost:5432/magaz
    username: postgres
    password: root

     */


}

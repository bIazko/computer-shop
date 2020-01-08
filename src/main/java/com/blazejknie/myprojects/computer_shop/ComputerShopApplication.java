package com.blazejknie.myprojects.computer_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ComputerShopApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ComputerShopApplication.class, args);
    }

}

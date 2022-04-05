package com.hkvszk.springbootweb;

import com.hkvszk.springbootweb.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootWebApplication {

    /**
     *
     * 原来为，SpringApplication.run(SpringBootWebApplication.class, args);
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);
        System.out.println(context.getBean(UserService.class).getClass().getName());
    }

}

package com.hkvszk.admin_serve;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @EnableAdminServer 标识
 */
@EnableAdminServer
@SpringBootApplication
public class AdminServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServeApplication.class, args);
    }

}

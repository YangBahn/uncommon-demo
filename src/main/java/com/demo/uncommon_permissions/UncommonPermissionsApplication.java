package com.demo.uncommon_permissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UncommonPermissionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UncommonPermissionsApplication.class, args);
    }

}

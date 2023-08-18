package com.mehrdad.falahati.shopping.list.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.mehrdad.falahati.shopping.list.data.access")
@EnableJpaRepositories(basePackages = "com.mehrdad.falahati.shopping.list.data.access")
@SpringBootApplication(scanBasePackages = "com.mehrdad.falahati")
public class ShoppingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApplication.class, args);
    }
}

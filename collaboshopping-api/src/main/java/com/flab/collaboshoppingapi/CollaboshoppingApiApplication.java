package com.flab.collaboshoppingapi;

import com.flab.collaboshoppingapp.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Application.class, CollaboshoppingApiApplication.class})
@EnableJpaRepositories
@EntityScan
public class CollaboshoppingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaboshoppingApiApplication.class, args);
    }

}

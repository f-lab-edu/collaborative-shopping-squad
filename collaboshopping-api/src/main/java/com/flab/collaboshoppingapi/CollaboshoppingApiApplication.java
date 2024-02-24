package com.flab.collaboshoppingapi;

import com.flab.collaboshoppingapp.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Application.class, CollaboshoppingApiApplication.class})
public class CollaboshoppingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaboshoppingApiApplication.class, args);
    }

}

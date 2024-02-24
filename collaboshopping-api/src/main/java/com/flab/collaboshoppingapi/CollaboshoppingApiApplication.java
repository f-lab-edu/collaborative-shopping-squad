package com.flab.collaboshoppingapi;

import com.flab.collaboshoppingapp.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration .class})
@ComponentScan(basePackageClasses = {Application.class})
public class CollaboshoppingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaboshoppingApiApplication.class, args);
    }

}

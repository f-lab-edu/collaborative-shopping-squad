package com.flab.collaboshoppingapp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {com.flab.collaboshoppingapp.Application.class})
@EnableJpaRepositories(basePackageClasses = {com.flab.collaboshoppingapp.Application.class})
public class DataSourceConfig {
}

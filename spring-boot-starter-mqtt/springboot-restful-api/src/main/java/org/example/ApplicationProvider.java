package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class },scanBasePackages = {"org.example"})
@EnableScheduling
@EnableAsync
public class ApplicationProvider implements WebMvcConfigurer {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication.run(ApplicationProvider.class, args);
    }
}

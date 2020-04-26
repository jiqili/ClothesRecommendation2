package com.example.android;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class AndroidApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidApplication.class, args);
    }

}

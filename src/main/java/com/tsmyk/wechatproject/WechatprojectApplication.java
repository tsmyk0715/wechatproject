package com.tsmyk.wechatproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WechatprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatprojectApplication.class, args);
    }

}

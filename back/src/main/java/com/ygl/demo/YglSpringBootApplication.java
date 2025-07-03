package com.ygl.demo;

import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "com.ygl")
@ServletComponentScan("com.ygl.filter")
@MapperScan({"com.ygl.mapper.write", "com.ygl.mapper.read"})
public class YglSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(YglSpringBootApplication.class, args);
    }
}

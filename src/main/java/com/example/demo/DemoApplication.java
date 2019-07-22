package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.demo.entity", "com.example.demo.controller",
  //  "com.example.demo.config",
    //"com.example.demo.model", "com.example.demo.repository", "com.example.demo.service",
    //"com.example.demo.controller"})
//@EnableJpaRepositories(basePackages = "com.example.demo.repository")
//@EntityScan(basePackages = {"com.example.demo.entity","com.example.demo.controller","com.example.demo.config",
//		"com.example.demo.model","com.example.demo.repository","com.example.demo.service","com.example.demo.controller"})
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}

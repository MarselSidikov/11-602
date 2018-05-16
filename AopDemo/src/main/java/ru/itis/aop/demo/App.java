package ru.itis.aop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 15.05.2018
 * App
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@ComponentScan("ru.itis.aop.demo")
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);

    }
}

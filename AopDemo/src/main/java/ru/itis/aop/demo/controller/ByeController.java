package ru.itis.aop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.aop.demo.service.ByeService;
import ru.itis.aop.demo.service.HelloService;

/**
 * 15.05.2018
 * UserController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class ByeController {

    @Autowired
    private ByeService service;

    @GetMapping("/bye")
    public ResponseEntity<String> getByeMessage() {
        return ResponseEntity.ok(service.getByeMessage());
    }
}

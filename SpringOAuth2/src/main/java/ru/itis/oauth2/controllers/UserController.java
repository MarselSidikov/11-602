package ru.itis.oauth2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.oauth2.models.User;
import ru.itis.oauth2.repositories.UsersRepository;

import java.util.List;

/**
 * 15.05.2018
 * UserController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<User>> getHello() {
        return ResponseEntity.ok(usersRepository.findAll());
    }
}

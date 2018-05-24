package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.models.User;
import ru.itis.rest.services.UsersService;
import ru.itis.rest.transfer.UserDto;

import java.util.List;

/**
 * 23.05.2018
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = service.getUsers();
        return ResponseEntity.ok(users);
    }
}

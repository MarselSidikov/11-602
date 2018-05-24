package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.forms.LoginForm;
import ru.itis.rest.services.LoginService;
import ru.itis.rest.transfer.TokenDto;

import javax.annotation.security.PermitAll;

/**
 * 23.05.2018
 * LoginController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    @PermitAll
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm form,
                                          @RequestParam(value = "jwt",required = false) Boolean jwtEnabled) {
        if (jwtEnabled != null && jwtEnabled) {
            return ResponseEntity.ok(service.loginAndCreateJwt(form.getLogin(), form.getPassword()));
        }
        return ResponseEntity.ok(service.login(form.getLogin(), form.getPassword()));
    }
}

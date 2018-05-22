package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.services.AdminService;

/**
 * 22.05.2018
 * AdminController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "AdminPage";
    }

    @PostMapping("/admin/as_user")
    public ResponseEntity<String> getTempPassword(@RequestParam("login") String login) {
        String tempPassword = service.createTempPasswordFor(login);
        return ResponseEntity.ok(tempPassword);
    }
}

package ru.itis.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.security.details.UserDetailsImpl;

/**
 * 19.05.2018
 * HelloController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String getHelloPage(Authentication authentication,
                               ModelMap model) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("name", userDetails.getUsername());
        return "HelloPage";
    }
}

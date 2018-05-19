package ru.itis.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 19.05.2018
 * AuthenticationController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class AuthenticationController {

    @GetMapping("/")
    public String getRoot(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        } else {
            return "redirect:/hello";
        }
    }

    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request,
                               ModelMap model,
                               Authentication authentication) {

        if (authentication != null) {
            return "redirect:/";
        }

        Map<String, String[]> params = request.getParameterMap();

        if (params.containsKey("error")) {
            model.addAttribute("error", true);
        }
        return "login";
    }
}

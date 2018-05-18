package ru.itis.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.service.model.User;
import ru.itis.service.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 17.05.2018
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersController implements Controller {

    @Autowired
    private UsersService service;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<String> names = service.getAllNames();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("namesFromServer", names);
        return modelAndView;
    }
}

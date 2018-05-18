package ru.itis.service.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.service.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 17.05.2018
 * UsersServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServlet extends HttpServlet {

    private UsersService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        service = context.getBean("usersService", UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> names = service.getAllNames();
        request.setAttribute("namesFromServer", names);
        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }
}

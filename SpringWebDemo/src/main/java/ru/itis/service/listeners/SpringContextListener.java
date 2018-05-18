package ru.itis.service.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 17.05.2018
 * SpringContextListener
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SpringContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        servletContextEvent.getServletContext().setAttribute("context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

package ru.itis.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.service.repository.UsersRepository;
import ru.itis.service.repository.UsersRepositoryJdbcImpl;
import ru.itis.service.services.UsersService;
import ru.itis.service.services.UsersServiceImpl;

import javax.sql.DataSource;

/**
 * 15.05.2018
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("ru.itis\\context.xml");

        UsersService usersService = context.getBean("usersService", UsersService.class);
        System.out.println(usersService.getAllNames());
    }
}

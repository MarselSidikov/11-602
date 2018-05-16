package ru.itis.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.service.repository.UsersRepository;
import ru.itis.service.repository.UsersRepositoryJdbcImpl;
import ru.itis.service.services.UsersService;
import ru.itis.service.services.UsersServiceImpl;

import javax.sql.DataSource;

/**
 * 15.05.2018
 * ApplicationContext
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Configuration
public class ApplicationContext {

//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public UsersRepository usersRepository() {
//        return new UsersRepositoryJdbcImpl(dataSource);
//    }
//
//    @Bean
//    public UsersService usersService() {
//        return new UsersServiceImpl(usersRepository());
//    }
}

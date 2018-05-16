package ru.itis.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.service.model.User;
import ru.itis.service.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 15.05.2018
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component(value = "usersService")
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<String> getAllNames() {
        List<User> users = usersRepository.findAll();
        return users.stream().map(User::getName).collect(Collectors.toList());
    }
}

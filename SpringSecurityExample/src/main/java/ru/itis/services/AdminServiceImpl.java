package ru.itis.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repository.UsersRepository;

import java.util.Optional;

/**
 * 22.05.2018
 * AdminServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createTempPasswordFor(String login) {
        Optional<User> candidate = usersRepository.findByLogin(login);
        if (candidate.isPresent()) {
            String tempPassword = RandomStringUtils.random(10, true, true);
            User user = candidate.get();
            user.setTempPasswordHash(passwordEncoder.encode(tempPassword));
            usersRepository.save(user);
            return tempPassword;
        }
        return "";
    }
}

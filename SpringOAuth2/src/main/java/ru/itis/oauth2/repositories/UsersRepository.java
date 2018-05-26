package ru.itis.oauth2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.oauth2.models.User;

import java.util.Optional;

/**
 * 03.11.2017
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
}

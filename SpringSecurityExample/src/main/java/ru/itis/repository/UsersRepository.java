package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.User;

import java.util.Optional;

/**
 * 19.05.2018
 * UsersRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}

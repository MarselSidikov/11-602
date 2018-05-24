package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;

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

    @Query(value = "SELECT * FROM rest_user " +
            "LEFT JOIN token ON token.user_id = rest_user.id " +
            "WHERE token.value = ?1", nativeQuery = true)
    Optional<User> findOneByToken(String token);
}

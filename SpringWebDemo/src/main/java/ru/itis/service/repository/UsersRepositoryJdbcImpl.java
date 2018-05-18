package ru.itis.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.service.model.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * 15.05.2018
 * UsersRepositoryJdbcImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component(value = "usersRepository")
public class UsersRepositoryJdbcImpl implements UsersRepository {
    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM users_602.public.student";

    private JdbcTemplate template;

    @Autowired
    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (row, rowNumber) -> new User(row.getLong(1),
            row.getString(2));

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(User model) {

    }

    @Override
    public User find(Long id) {
        return null;
    }
}

package ru.itis.rest.forms;

import lombok.Data;

/**
 * 23.05.2018
 * LoginForm
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class LoginForm {
    private String login;
    private String password;
}

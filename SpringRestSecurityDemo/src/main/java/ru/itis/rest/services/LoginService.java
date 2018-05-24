package ru.itis.rest.services;

import ru.itis.rest.transfer.TokenDto;

/**
 * 23.05.2018
 * LoginService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LoginService {
    TokenDto login(String login, String password);

    TokenDto loginAndCreateJwt(String login, String password);
}

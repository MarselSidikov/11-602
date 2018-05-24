package ru.itis.rest.services;

import ru.itis.rest.transfer.UserDto;

import java.util.List;

/**
 * 23.05.2018
 * UsersService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<UserDto> getUsers();
}

package ru.itis.rest.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.itis.rest.security.authentication.TokenAuthentication;

/**
 * 24.04.2018
 * TokenAuthenticationProvider
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // испольузем явное преобразование для
        // конвертации объекта аутентификации
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
        // достаем пользователя по токену
        UserDetails userDetails = userDetailsService.loadUserByUsername(tokenAuthentication.getName());
//      // в объект аутентификации кладем права пользователя
        tokenAuthentication.setUserDetails(userDetails);
        // говорим, что данный пользователь аутентифицирован
        tokenAuthentication.setAuthenticated(true);
        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.isAssignableFrom(authentication);
    }
}

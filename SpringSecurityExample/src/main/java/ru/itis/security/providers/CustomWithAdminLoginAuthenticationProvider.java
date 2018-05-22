package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.models.User;
import ru.itis.repository.UsersRepository;
import ru.itis.security.details.UserDetailsImpl;

/**
 * 22.05.2018
 * CustomWithAdminLoginAuthenticationProvider
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class CustomWithAdminLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserDetailsService service;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetailsImpl currentUser = (UserDetailsImpl)service.loadUserByUsername(login);

        if (isCorrectUserPassword(currentUser, password)) {
            return new UsernamePasswordAuthenticationToken(
                    currentUser, password, currentUser.getAuthorities());
        } else if (isCorrectUserTempPassword(currentUser, password)) {
            User user = usersRepository.findByLogin(login).get();
            user.setTempPasswordHash(null);
            usersRepository.save(user);
            return new UsernamePasswordAuthenticationToken(
                    currentUser, password, currentUser.getAuthorities());
        }
        throw new BadCredentialsException("User not found");
    }

    private boolean isCorrectUserPassword(UserDetails currentUser, String password) {
        return encoder.matches(password, currentUser.getPassword());
    }

    private boolean isCorrectUserTempPassword(UserDetailsImpl currentUser, String tempPassword) {
        return encoder.matches(tempPassword, currentUser.getTempPasswordHash());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

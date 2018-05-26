package ru.itis.oauth2.security.details;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.oauth2.models.User;
import ru.itis.oauth2.security.role.Role;

import java.util.Collection;
import java.util.Collections;

/**
 * 05.08.2017
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version 1.0
 */
// класс, который помогает спрингу понять, как устроена ваша сущность для авторизации
public class UserDetailsImpl implements UserDetails {

    private String hashPassword;
    private String login;
    private GrantedAuthority authority;

    public UserDetailsImpl(User user) {
        this.hashPassword = user.getHashPassword();
        this.login = user.getLogin();
        this.authority = new SimpleGrantedAuthority(user.getRole().toString());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return hashPassword;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

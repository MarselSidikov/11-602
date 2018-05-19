package ru.itis.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.models.User;

import java.util.Collection;
import java.util.Collections;

/**
 * 19.05.2018
 * UserDetailsImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String passwordHash;
    private String login;
    private String role;

    private UserDetailsImpl(Long id, String passwordHash, String login, String role) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.login = login;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return passwordHash;
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

    public static UserDetailsImpl from(User user) {
        return new UserDetailsImpl(user.getId(),
                user.getPasswordHash(), user.getLogin(),
                user.getRole().toString());
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}

package ru.itis.rest.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.rest.models.Token;
import ru.itis.rest.models.User;
import ru.itis.rest.repositories.TokensRepository;
import ru.itis.rest.repositories.UsersRepository;
import ru.itis.rest.transfer.TokenDto;

import java.util.Optional;
import java.util.UUID;

/**
 * 23.05.2018
 * LoginServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public TokenDto login(String login, String password) {
        Optional<User> candidate = usersRepository.findOneByLogin(login);
        if (candidate.isPresent()) {
            User currentUser = candidate.get();
            if (encoder.matches(password, currentUser.getHashPassword())) {
                Token token = Token.builder()
                        .user(currentUser)
                        .value(UUID.randomUUID().toString())
                        .build();
                tokensRepository.save(token);
                return new TokenDto(token.getValue());
            } else {
                throw new BadCredentialsException("User not found");
            }
        }
        throw new BadCredentialsException("User not found");
    }

    @Override
    public TokenDto loginAndCreateJwt(String login, String password) {
        Optional<User> candidate = usersRepository.findOneByLogin(login);
        if (candidate.isPresent()) {
            User currentUser = candidate.get();
            if (encoder.matches(password, currentUser.getHashPassword())) {
                String jwtToken = Jwts.builder()
                        .claim("role", currentUser.getRole().toString())
                        .claim("login", currentUser.getLogin())
                        .setSubject(currentUser.getId().toString())
                        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
                return TokenDto.builder().token(jwtToken).build();
            } throw new BadCredentialsException("User not found");
        } throw new BadCredentialsException("User not found");

    }
}

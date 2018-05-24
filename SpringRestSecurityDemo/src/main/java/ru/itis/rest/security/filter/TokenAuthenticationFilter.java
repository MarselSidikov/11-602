package ru.itis.rest.security.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itis.rest.security.authentication.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 23.05.2018
 * TokenAuthenticationFilter
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class TokenAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // принимаем запрос и конвертируем его в HTTPServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // Вытаскиваем токен из заголовка
        String token = request.getHeader("Auth-Token");
        TokenAuthentication authentication;
        // если токен в заголовке не найден
        if (token == null) {
            // вытаскиваю его из параметра запроса
            token = request.getParameter("token");
        }
        // если токен все еще не null
        if (token != null) {
            // создаем объект аутентификации
            authentication = new TokenAuthentication(token);
            // отдаем его явно контексту безопасности
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

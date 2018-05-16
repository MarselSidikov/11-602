package ru.itis.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 15.05.2018
 * AfterLoggingAspect
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Aspect
@Configuration
public class BeforeLoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "execution(* ru.itis.aop.demo.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("Before execution of {}", joinPoint);
    }
}

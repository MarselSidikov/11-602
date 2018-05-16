package ru.itis.aop.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 15.05.2018
 * HelloService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class HelloService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getHelloMessage() {
        //logger.info("In HelloService getHelloMessage");
        return "hello";
    }
}

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
public class ByeService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getByeMessage() {
        //logger.info("In ByeService getByeMessage");
        return "bye";
    }
}

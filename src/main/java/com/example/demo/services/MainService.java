package com.example.demo.services;

import com.example.demo.aspect.LogDuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private static final Logger logger = LogManager.getLogger(MainService.class);

    @Autowired
    private OtherService otherService;

    private int count = 0;

    @LogDuration
    public void process() throws Exception {
        MDC.clear();

        MDC.put("user", getUser());
        logger.info("We are making a big processing and calling into another service");
        otherService.otherTask();

    }

    private String getUser() {
        return "userName"+(++count);
    }

}

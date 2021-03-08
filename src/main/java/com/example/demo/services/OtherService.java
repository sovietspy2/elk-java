package com.example.demo.services;

import com.example.demo.aspect.LogDuration;
import com.example.demo.exception.CustomBusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class OtherService {

    private static final Logger logger = LogManager.getLogger(OtherService.class);

    @LogDuration
    public void otherTask() throws Exception {

        try {
            if(Math.random() > 0.5){
                throw new CustomBusinessException();
            }

            logger.info("Finished other task");

        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

}

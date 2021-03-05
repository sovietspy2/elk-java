package com.example.demo.services;

import com.example.demo.aspect.LogDuration;
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
                throw new Exception("uh random exception");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info("Finished other task");

    }

}

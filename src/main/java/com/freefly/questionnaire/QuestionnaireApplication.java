package com.freefly.questionnaire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionnaireApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Springboot is running !!!");
        SpringApplication.run(QuestionnaireApplication.class, args);
    }

}

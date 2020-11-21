package com.freefly.questionnaire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.freefly.questionnairer")
public class QuestionnaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireApplication.class, args);
    }
}

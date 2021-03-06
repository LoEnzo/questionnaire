package com.freefly.questionnaire;

import com.yomahub.tlog.core.enhance.bytes.AspectLogEnhance;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.freefly.questionnaire.mapper")
public class QuestionnaireApplication {

    // 进行日志增强，自动判断日志框架，适用于log4j，logback，log4j2会自动识别Tlog里面的适配插件
    static {
        AspectLogEnhance.enhance();}

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireApplication.class, args);
    }
}

package com.freefly.questionnaire.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/21 20:00
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String getHello() {
        return "Hello Springboot!";
    }
}

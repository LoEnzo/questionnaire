package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.dto.Questionnaire;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/21 20:57
 */
@RestController
@RequestMapping("/option")
@Api(tags = "问卷回答选项")
public class OptionController {

    @GetMapping(value = "/{optionId}")
    public Questionnaire queryQuestionnaire(@PathVariable String answerId) {
        return new Questionnaire();
    }
}

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
 * @Date2020/11/4 10:50
 */
@RestController
@RequestMapping("/questionnaire")
@Api(tags = "问卷表信息")
public class QuestionnaireController {

    @GetMapping(value = "/{questNaId}")
    public Questionnaire queryQuestionnaire(@PathVariable String questNaId) {
        return new Questionnaire();
    }
}

package com.freefly.questionnaire.controller.question;

import com.freefly.questionnaire.dto.Questionnaire;
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
@RequestMapping("/question")
public class QuestionController {

    @GetMapping(value = "/{quesId}")
    public Questionnaire queryQuestionnaire(@PathVariable String quesId) {
        return new Questionnaire();
    }
}

package com.freefly.questionnaire.controller.answer;

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
 * @Date2020/11/4 10:51
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @GetMapping(value = "/{answerId}")
    public Questionnaire queryQuestionnaire(@PathVariable String answerId) {
        return new Questionnaire();
    }
}

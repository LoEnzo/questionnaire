package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.service.QuestionnaireService;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/4 10:50
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/que")
@Api(tags = "问卷表信息")
@Slf4j
public class QuestionnaireController {

    @Resource
    private QuestionnaireService questionnaireService;

    @ApiOperation(value = "查询问卷表")
    @GetMapping(value = "/{queId}")
    public SurveyQuestionnaire queryQuestionnaire(@PathVariable int queId) {
        log.info("SUCCESS");
        return questionnaireService.queryQuestionnaire(queId);
    }

    @PostMapping()
    @ApiOperation(value = "删除问卷表")
    public void addQuestionnaire(SurveyQuestionnaire surveyQuestionnaire) {
        // TODO
        int userId = 1;
        questionnaireService.addQuestionnaire(surveyQuestionnaire, userId);
    }

    @PutMapping()
    @ApiOperation(value = "更新问卷表")
    public void updateQuestionnaire(SurveyQuestionnaire surveyQuestionnaire) {
        // TODO
        int userId = 1;
        questionnaireService.updateQuestionnaire(surveyQuestionnaire, userId);
    }

    @DeleteMapping(value = "/{questionnaireId}")
    @ApiOperation(value = "删除问卷表")
    public void deleteQuestionnaire(@PathVariable int questionnaireId) {
        // TODO
        int userId = 1;
        questionnaireService.deleteQuestionnaire(questionnaireId, userId);
    }

    @GetMapping
    @ApiOperation(value = "获取模板库的分类")
    public void queryQuestionnaireType(){
        // TODO
        int userId = 1;
    }
}

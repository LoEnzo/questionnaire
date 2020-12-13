package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.service.QuestionnaireService;
import com.freefly.questionnaire.service.TemplateService;
import com.freefly.questionnaire.vo.ResultEntity;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description: 模板库控制层
 *
 * @Author hjwu
 * @Date2020/12/3 14:39
 */
@RestController
@Api(tags = "问卷模板库")
@RequestMapping("/templates")
public class TemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @Resource
    private QuestionnaireService questionnaireService;

    @Resource
    private TemplateService templateService;

    @GetMapping("/{tempId}")
    @ApiOperation(value = "查询模板库问卷详细信息", notes = "根据模板库id查询具体某个模板问卷的信息")
    public ResponseEntity<ResultEntity<SurveyQuestionnaire>> getTemplateDetail(@PathVariable int tempId) {
        SurveyQuestionnaire templates = templateService.queryTemplateDetailById(tempId);
        return new ResponseEntity<>(ResultEntity.successWithData(HttpStatus.OK.value(), templates), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "查询模板关键字信息", notes = "根据关键字模糊查询模板库信息")
    public ResponseEntity<ResultEntity> getTemplates(@RequestParam String keyWord) {
        SurveyQuestionnaireTemplate surveyQuestionnaireTemplate = templateService.queryTemplates(keyWord);
        if (null != surveyQuestionnaireTemplate) {
            return ResponseEntity.ok(ResultEntity.successWithData(HttpStatus.OK.value(), surveyQuestionnaireTemplate));
        } else {
            return new ResponseEntity<>(ResultEntity.failedWithData(HttpStatus.NOT_FOUND.value(), "未查询到数据"),
                    HttpStatus.NOT_FOUND);
        }
    }
}

package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.service.TemplateService;
import com.freefly.questionnaire.vo.ResultEntity;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
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
@CrossOrigin
@Api(tags = "问卷模板库")
@Slf4j
public class TemplateController {

    @Resource
    private TemplateService templateService;

    @GetMapping("/templateDetail/{tempId}")
    @ApiOperation(value = "查询模板库问卷详细信息", notes = "根据模板库id查询具体某个模板问卷的信息")
    public ResultEntity<SurveyQuestionnaire> getTemplateDetail(@PathVariable int tempId) {

        SurveyQuestionnaire templates = templateService.queryTemplateDetailById(tempId);
        templates.setTotal(templates.getSurveyQuestionOptionList().size());
        return ResultEntity.successWithData(HttpStatus.OK.value(), templates);
    }

    @GetMapping("/templates")
    @ApiOperation(value = "查询模板关键字信息", notes = "根据关键字模糊查询模板库信息")
    public ResultEntity<?> getTemplates(@RequestParam(value = "keyWord", required = false) String keyWord) {

        List<SurveyQuestionnaireTemplate> surQueTemplateList = templateService.queryTemplates(keyWord);
        if (!ObjectUtils.isEmpty(surQueTemplateList)) {
            return ResultEntity.successWithData(HttpStatus.OK.value(), surQueTemplateList);
        } else {
            return ResultEntity.failedWithData(HttpStatus.NOT_FOUND.value(), "未查询到数据");
        }
    }
}

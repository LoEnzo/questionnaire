package com.freefly.questionnaire.service.impl;

import com.freefly.questionnaire.mapper.QuestionnaireMapper;
import com.freefly.questionnaire.mapper.TemplateMapper;
import com.freefly.questionnaire.service.TemplateService;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/12/4 10:49
 */
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Resource
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public SurveyQuestionnaireTemplate queryTemplates(String keyWord) {
        return templateMapper.queryTemplateByKeyWord(keyWord);
    }

    @Override
    public SurveyQuestionnaire queryTemplateDetailById(int id) {
        // 根据模板id查询模板库问卷表详细信息
        return questionnaireMapper.queryQuestionnaireByTempId(id);
    }
}

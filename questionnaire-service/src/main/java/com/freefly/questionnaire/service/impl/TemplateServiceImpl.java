package com.freefly.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.freefly.questionnaire.mapper.QuestionnaireMapper;
import com.freefly.questionnaire.mapper.TemplateMapper;
import com.freefly.questionnaire.service.TemplateService;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<SurveyQuestionnaireTemplate> queryTemplates(String keyWord) {

        return templateMapper.queryTemplateByKeyWord(keyWord,
                new QueryWrapper<SurveyQuestionnaireTemplate>()
                        .like(StringUtils.isNotBlank(keyWord), "sq.title", keyWord));
    }

    @Override
    public SurveyQuestionnaire queryTemplateDetailById(int id) {

        return questionnaireMapper.queryQuestionnaireByTempId(id,
                new QueryWrapper<SurveyQuestionnaire>()
                        .eq("template_id", id));
    }
}

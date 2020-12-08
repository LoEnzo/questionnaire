package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;

public interface TemplateService {

    SurveyQuestionnaireTemplate queryTemplates(String keyWord);

    SurveyQuestionnaireTemplate queryTemplateById(int id);
}

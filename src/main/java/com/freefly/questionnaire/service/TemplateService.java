package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;

public interface TemplateService {

    SurveyQuestionnaireTemplate queryTemplates(String keyWord);

    SurveyQuestionnaire queryTemplateDetailById(int id);
}

package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;

import java.util.List;

public interface TemplateService {

    List<SurveyQuestionnaireTemplate> queryTemplates(String keyWord);

    SurveyQuestionnaire queryTemplateDetailById(int id);
}

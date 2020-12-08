package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyQuestionOption;

import java.util.List;

public interface QuestionService {

    List<SurveyQuestionOption> queryQuestionOptionByQuestionnaireId(int id);
}

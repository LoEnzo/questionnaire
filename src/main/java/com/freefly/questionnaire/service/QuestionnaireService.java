package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyQuestionnaire;

public interface QuestionnaireService {

    SurveyQuestionnaire queryQuestionnaire(int id);

    SurveyQuestionnaire queryQuestionnaire(String keyWord);

    void addQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int userId);

    void updateQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int useId);

    void deleteQuestionnaire(int questionnaireId, int userId);
}

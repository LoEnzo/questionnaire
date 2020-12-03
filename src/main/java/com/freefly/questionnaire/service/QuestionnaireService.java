package com.freefly.questionnaire.service;

import com.freefly.questionnaire.dto.SurveyQuestionnaire;

public interface QuestionnaireService {

    SurveyQuestionnaire queryQuestionnaire(int id);

    void addQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int userId);

    void updateQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int useId);

    void deleteQuestionnaire(int questionnaireId, int userId);
}

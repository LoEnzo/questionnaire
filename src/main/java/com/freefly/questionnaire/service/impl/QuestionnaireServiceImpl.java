package com.freefly.questionnaire.service.impl;

import com.freefly.questionnaire.dto.SurveyQuestionnaire;
import com.freefly.questionnaire.mapper.QuestionnaireMapper;
import com.freefly.questionnaire.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/28 19:28
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Resource
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public SurveyQuestionnaire queryQuestionnaire(int id) {
        return questionnaireMapper.queryQuestionnaireById(id);
    }

    @Override
    public void addQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int userId) {
        questionnaireMapper.addQuestionnaire(surveyQuestionnaire.getTitle(), surveyQuestionnaire.getType(),
                surveyQuestionnaire.getDescription(), surveyQuestionnaire.getStatus(),
                surveyQuestionnaire.getCreateTime(), surveyQuestionnaire.getEndTime(), userId);
    }

    @Override
    public void updateQuestionnaire(SurveyQuestionnaire surveyQuestionnaire, int userId) {
        questionnaireMapper.updateQuestionnaire(surveyQuestionnaire.getTitle(), surveyQuestionnaire.getType(),
                surveyQuestionnaire.getDescription(), surveyQuestionnaire.getStatus(),
                surveyQuestionnaire.getCreateTime(), surveyQuestionnaire.getEndTime(), surveyQuestionnaire.getId(),
                userId);
    }

    @Override
    public void deleteQuestionnaire(int questionnaireId, int userId) {
        questionnaireMapper.deleteQuestionnaireById(questionnaireId, userId);
    }
}

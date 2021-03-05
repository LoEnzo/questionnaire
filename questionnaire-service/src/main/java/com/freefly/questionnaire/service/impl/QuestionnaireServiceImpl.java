package com.freefly.questionnaire.service.impl;

import com.freefly.questionnaire.mapper.QuestionMapper;
import com.freefly.questionnaire.mapper.QuestionnaireMapper;
import com.freefly.questionnaire.service.QuestionnaireService;
import com.freefly.questionnaire.vo.SurveyQuestionOption;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public SurveyQuestionnaire queryQuestionnaire(int id) {
        // 根据id查询问卷表信息
        SurveyQuestionnaire questionnaire = questionnaireMapper.queryQuestionnaireById(id);
        // 根据id查询问题表信息
        List<SurveyQuestionOption> questionOptionList = questionMapper.queryQuestionOptionByQuestionnaireId(id);
        questionnaire.setSurveyQuestionOptionList(questionOptionList);
        return questionnaire;
    }

    @Override
    public SurveyQuestionnaire queryQuestionnaire(String keyWord) {
        return questionnaireMapper.queryQuestionnaireByKeyWord(keyWord);
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

package com.freefly.questionnaire.service.impl;

import com.freefly.questionnaire.mapper.QuestionMapper;
import com.freefly.questionnaire.service.QuestionService;
import com.freefly.questionnaire.vo.SurveyQuestionOption;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/12/6 15:07
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public List<SurveyQuestionOption> queryQuestionOptionByQuestionnaireId(int id) {
        return questionMapper.queryQuestionOptionByQuestionnaireId(id);
    }
}

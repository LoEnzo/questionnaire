package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TemplateMapper {

    @ResultMap("SurveyTemplateResultMap")
    SurveyQuestionnaireTemplate queryTemplateByKeyWord(String keyWord);
}

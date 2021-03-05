package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TemplateMapper {

    @ResultMap("SurveyTemplateResultMap")
    List<SurveyQuestionnaireTemplate> queryTemplateByKeyWord(String keyWord);

    @ResultMap("SurveyTemplateResultMap")
    SurveyQuestionnaireTemplate queryTemplateByKeyWord();
}

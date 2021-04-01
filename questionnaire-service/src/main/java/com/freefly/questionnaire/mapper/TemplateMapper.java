package com.freefly.questionnaire.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

@Mapper
public interface TemplateMapper extends BaseMapper<SurveyQuestionnaireTemplate> {

    @ResultMap("SurveyTemplateResultMap")
    List<SurveyQuestionnaireTemplate> queryTemplateByKeyWord(String keyWord, @Param(Constants.WRAPPER) Wrapper wrapper);

    SurveyQuestionnaireTemplate queryTemplateByKeyWord(Wrapper<String> queryWrapper);
}

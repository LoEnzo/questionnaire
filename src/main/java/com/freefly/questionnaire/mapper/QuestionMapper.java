package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.vo.SurveyQuestionOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("SELECT * FROM survey_question WHERE id = #{id, jdbcType=INTEGER}")
    List<SurveyQuestionOption> queryQuestionOptionByQuestionnaireId(int id);
}

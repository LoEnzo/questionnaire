package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TemplateMapper {

    @ResultMap("SurveyTemplateResultMap")
    @Select("SELECT * FROM user WHERE id = #{id, jdbcType=VARCHAR}")
    SurveyQuestionnaireTemplate queryTemplateByKerWord(String keyWord);

    @ResultMap("SurveyTemplateResultMap")
    @Select("SELECT id,sort,user_number FROM survey_questionnaire_template WHERE id = #{id, jdbcType=INTEGER}")
    @Results({
            @Result(column = "questionnaire_id", property = "questionnaireId",
                    many = @Many(select = "com.freefly.questionnaire.mapper.queryQuestionnaireById"))
    })
    SurveyQuestionnaireTemplate queryTemplateById(int id);


}

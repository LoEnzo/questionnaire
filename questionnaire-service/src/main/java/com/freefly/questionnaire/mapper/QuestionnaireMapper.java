package com.freefly.questionnaire.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.freefly.questionnaire.mapper.sql.QuestionnaireSql;
import com.freefly.questionnaire.vo.SurveyQuestionnaire;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

@Mapper
public interface QuestionnaireMapper {

    @InsertProvider(type = QuestionnaireSql.class, method = "addQuestionnaire")
    void addQuestionnaire(@Param("title") String title, @Param("type") String type,
                          @Param("description") String description, @Param("status") int status,
                          @Param("create_time") LocalDateTime createTime, @Param("end_time") LocalDateTime endTime,
                          @Param("user_id") int userId);


    @Delete("DELETE FROM survey_questionnaire WHERE id = #{id, jdbcType=INTEGER} AND user_id = #{userId, " +
            "jdbcType=INTEGER}")
    void deleteQuestionnaireById(@Param("id") int id, @Param("user_id") int userId);

    @UpdateProvider(type = QuestionnaireSql.class, method = "updateQuestionnaire")
    void updateQuestionnaire(@Param("title") String title, @Param("type") String type,
                             @Param("description") String description, @Param("status") int status,
                             @Param("create_time") LocalDateTime createTime, @Param("end_time") LocalDateTime endTime,
                             @Param("id") int id, @Param("user_id") int userId);

    @ResultMap("SurveyQuestionnaireResultMap")
    @Select("SELECT * FROM survey_questionnaire WHERE id = #{id, jdbcType=INTEGER}")
    SurveyQuestionnaire queryQuestionnaireById(int id);


    SurveyQuestionnaire queryQuestionnaireByTempId(int id, @Param(Constants.WRAPPER) Wrapper wrapper);

    @SelectProvider(type = QuestionnaireSql.class, method = "queryTemplateByKeyWord")
    SurveyQuestionnaire queryQuestionnaireByKeyWord(String keyWord);

}

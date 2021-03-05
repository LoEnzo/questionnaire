package com.freefly.questionnaire.mapper.sql;


/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/28 21:26
 */
public class QuestionnaireSql {

    public String addQuestionnaire() {
        return "";
    }

    public String updateQuestionnaire() {
        return "";
    }

    public String queryTemplateByKeyWord() {
        return "SELECT title " +
                "FROM survey_questionnaire " +
                "WHERE name " +
                "LIKE CONCAT ('%',#{name, jdbcType=VARCHAR}, '%')";
    }
}

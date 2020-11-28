package com.freefly.questionnaire.mapper.sql;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/27 14:25
 */
public class UserSql {

    public String addUser() {
        return "insert into User " +
                    "(name, password) " +
                "values " +
                    "(#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})";
    }

    public String updateUserById(){
        return "UPDATE User " +
                "SET " +
                    "name = #{name,jdbcType=VARCHAR}, password = #{password,jdbcType=VARCHAR}" +
                " WHERE " +
                    "id = #{id, jdbcType=INTEGER}";
    }
}

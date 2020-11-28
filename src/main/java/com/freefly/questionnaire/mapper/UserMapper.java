package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.dto.SurveyUser;
import com.freefly.questionnaire.mapper.sql.UserSql;
import org.apache.ibatis.annotations.*;

/**
 * ProjectName
 * ClassName
 * Class Description
 *
 * @Author hjwu
 * @Date 2020/5/9 16:25
 **/
@Mapper
public interface UserMapper {

    @ResultMap("SurveyUserResultMap")
    @Select("SELECT * FROM USER WHERE id = #{id, jdbcType=INTEGER}")
    SurveyUser queryUserById(int id);

    @ResultMap("SurveyUserResultMap")
    @InsertProvider(type = UserSql.class, method = "addUser")   // type指明SQL工厂类，method是工厂类里对应的方法
    void addUser(@Param("name") String name, @Param("password") String password);

    @Delete("DELETE FROM User WHERE id = #{id, jdbcType=INTEGER}")
    void deleteUsersById(int id);

    @DeleteProvider(type = UserSql.class, method = "updateUserById")
    void updateUserById(@Param("name") String name, @Param("password") String password, @Param("id") int id);

}

package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.dto.SurveyUser;
import com.freefly.questionnaire.mapper.sql.UserSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Param;

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
    @Select("SELECT * FROM user WHERE id = #{id, jdbcType=INTEGER}")
    SurveyUser queryUserById(int id);

    @InsertProvider(type = UserSql.class, method = "addUser")   // type指明SQL工厂类，method是工厂类里对应的方法
    void addUser(@Param("name") String name, @Param("password") String password);

    @Delete("DELETE FROM User WHERE id = #{id, jdbcType=INTEGER}")
    void deleteUsersById(int id);

    @UpdateProvider(type = UserSql.class, method = "updateUserById")
    void updateUserById(@Param("name") String name, @Param("password") String password, @Param("id") int id);

}

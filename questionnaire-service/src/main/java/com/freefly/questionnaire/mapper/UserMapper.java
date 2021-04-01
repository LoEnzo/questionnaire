package com.freefly.questionnaire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.freefly.questionnaire.mapper.sql.UserSql;
import com.freefly.questionnaire.vo.SurveyUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ProjectName
 * ClassName
 * Class Description
 *
 * @Author hjwu
 * @Date 2020/5/9 16:25
 **/
@Mapper
public interface UserMapper extends BaseMapper<SurveyUser> {

    /**
     * type指明SQL工厂类，method是工厂类里对应的方法
     *
     * @param name     用户名
     * @param password 密码
     * @Return void
     **/
    @InsertProvider(type = UserSql.class, method = "addUser")
    void addUser(@Param("name") String name, @Param("password") String password);

    /**
     * 根据用户id删除用户信息
     *
     * @param id 用户id
     * @Return void
     **/
    @Delete("DELETE FROM User WHERE id = #{id, jdbcType=INTEGER}")
    void deleteUsersById(int id);

    /**
     * 更新用户信息
     *
     * @param name     用户名
     * @param password 用户密码
     * @param id       用户id
     * @Return void
     **/
    @UpdateProvider(type = UserSql.class, method = "updateUserById")
    void updateUserById(@Param("name") String name, @Param("password") String password, @Param("id") int id);

    /**
     * 查询所有用户信息
     *
     * @Return java.util.List<com.freefly.questionnaire.vo.SurveyUser>
     **/
    @Select("SELECT * FROM user")
    List<SurveyUser> queryAllUser();

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @Return com.freefly.questionnaire.vo.SurveyUser
     **/
    SurveyUser selectById(int id);

}

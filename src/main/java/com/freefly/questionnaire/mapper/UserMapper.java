package com.freefly.questionnaire.mapper;

import com.freefly.questionnaire.dto.User;
import org.apache.ibatis.annotations.Mapper;
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

    User queryUserById(int id);

    void updateUsers(@Param("name") String name, @Param("password")String password);

    void addUsers(@Param("name") String name, @Param("password") String password);

    void deleteUsersById(int id);
}

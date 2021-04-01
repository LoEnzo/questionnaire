package com.freefly.questionnaire.service.impl;

import com.freefly.questionnaire.vo.SurveyUser;
import com.freefly.questionnaire.mapper.UserMapper;
import com.freefly.questionnaire.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/21 13:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(SurveyUser user) {
        userMapper.addUser(user.getUserName(), user.getPassword());
    }

    @Override
    public SurveyUser queryUser(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateUser(SurveyUser user) {
        userMapper.updateUserById(user.getUserName(), user.getPassword(), user.getId());
    }

    @Override
    public List<SurveyUser> queryAllUser() {
        return userMapper.queryAllUser();
    }

}

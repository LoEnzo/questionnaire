package com.freefly.questionnaire;

import com.freefly.questionnaire.vo.SurveyUser;
import com.freefly.questionnaire.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/27 16:51
 */
@RunWith(SpringRunner.class)
//加载主启动类
@SpringBootTest(classes = QuestionnaireApplication.class)
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectById() {

        SurveyUser user = userMapper.queryUserById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals("hjwu", user.getUserName());
    }
}

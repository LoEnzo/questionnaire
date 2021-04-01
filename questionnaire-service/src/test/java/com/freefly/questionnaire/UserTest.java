package com.freefly.questionnaire;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.freefly.questionnaire.mapper.TemplateMapper;
import com.freefly.questionnaire.mapper.UserMapper;
import com.freefly.questionnaire.vo.SurveyQuestionnaireTemplate;
import com.freefly.questionnaire.vo.SurveyUser;
import org.apache.ibatis.annotations.Select;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/27 16:51
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuestionnaireApplication.class)
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Resource
    private TemplateMapper templateMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testSelectById() {

        SurveyUser user = userMapper.selectById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals("hjwu", user.getUserName());
    }

    @Test
    public void testMybatisPlus(){
        List<SurveyUser> userList  = userMapper.selectList(new QueryWrapper<SurveyUser>()
            .eq("username", "admin"));
        Assert.assertNotNull(userList);
    }

    @Test
    public void testMybatisPlusQueryWrapper(){
        QueryWrapper<SurveyQuestionnaireTemplate> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", "大");
        List<SurveyQuestionnaireTemplate> list = templateMapper.selectList(queryWrapper);
        Assert.assertNotNull(list);
    }

//    @Test
    public void getToken() {
        // 获取Token请求路径
        String access_token_uri = "http://localhost:8080/questionnaire/oauth/token?grant_type=password&username=admin&password=123456";
        // 客户端Id
        String clientId = "ApiBoot";
        // 客户端Secret
        String clientSecret = "ApiBootSecret";
        // basic认证的格式
        String basicAuth = "Basic %s";

        // 可以使用注入RestTemplate方式获取对象实例
        RestTemplate restTemplate = new RestTemplate();
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        // 设置客户端的basic认证信息
        headers.set("Authorization", String.format(basicAuth, Base64Utils.encodeToString((clientId + ":" + clientSecret).getBytes())));
        // 请求主体
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        // 发送请求，获取access_token
        String access_token = restTemplate.postForObject(access_token_uri, httpEntity, String.class);

        System.out.println(access_token);
    }

    @Test
    public void setTest() throws Exception {

        redisTemplate.opsForValue().set("123", "123123123");
        System.out.println(
                "setTest:" + redisTemplate.opsForValue().get("123")
        );
    }
}

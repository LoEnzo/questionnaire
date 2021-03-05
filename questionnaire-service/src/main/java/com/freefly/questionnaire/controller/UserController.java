package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.vo.ResultEntity;
import com.freefly.questionnaire.vo.SurveyUser;
import com.freefly.questionnaire.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/10/27 18:03
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户信息")
public class UserController {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;


    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    public SurveyUser queryUser(@PathVariable int userId) {
        LOGGER.info("success");
        return userService.queryUser(userId);
    }

    @PostMapping
    @ApiOperation(value = "添加用户信息")
    public void addUser(SurveyUser user) {
        userService.addUser(user);
        LOGGER.info("Success");
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    public void updateUser(SurveyUser user) {
        userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable(value = "userId") String userId) {
    }
}

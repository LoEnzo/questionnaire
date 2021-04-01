package com.freefly.questionnaire.controller;

import com.freefly.questionnaire.service.UserService;
import com.freefly.questionnaire.vo.SurveyUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@Slf4j
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "查询用户信息", notes = "根据用户id查询用户信息")
    public SurveyUser queryUser(@PathVariable int userId) {
        log.info("success");
        return userService.queryUser(userId);
    }

    @PostMapping
    @ApiOperation(value = "添加用户信息")
    public void addUser(SurveyUser user) {
        userService.addUser(user);
        log.info("Success");
    }

    @PutMapping
    @ApiOperation(value = "更新用户信息")
    public void updateUser(SurveyUser user) {
        userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable(value = "userId") String userId) {
    }
}

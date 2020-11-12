package com.freefly.questionnaire.controller.user;

import com.freefly.questionnaire.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/{userId}")
    public User queryUser(@PathVariable String userId) {
        User user = new User();
        LOGGER.info("success");
        return user;
    }

    @PostMapping
    public void addUser(User user) {

    }

    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable(value = "userId") String userId) {
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable(value = "userId") String userId) {
    }

}

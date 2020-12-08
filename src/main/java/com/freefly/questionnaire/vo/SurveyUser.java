package com.freefly.questionnaire.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/4 10:20
 */
@Getter
@Setter
@Alias("SurveyUser")
public class SurveyUser{

    @ApiModelProperty(value = "用户id")
    private int id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

}

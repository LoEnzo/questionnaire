package com.freefly.questionnaire.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "sys_user", autoResultMap = true)
public class SurveyUser {

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "username")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "password")
    private String password;

}

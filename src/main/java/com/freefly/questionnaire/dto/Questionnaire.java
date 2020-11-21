package com.freefly.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/4 10:22
 */
@Getter
@Setter
@Alias("Questionnaire")
public class Questionnaire {

    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "问卷标题")
    private String title;

    @ApiModelProperty(value = "问卷描述")
    private String description;

    @ApiModelProperty(value = "问卷状态，0：未投递，1：已投递，2：已截止")
    private int status;

    @ApiModelProperty(value = "问卷创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "问卷截止时间")
    private LocalDateTime endTime;

}

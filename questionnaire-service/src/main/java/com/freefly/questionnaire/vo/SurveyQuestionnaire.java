package com.freefly.questionnaire.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

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
@Alias("SurveyQuestionnaire")
@TableName(value = "survey_questionnaire", autoResultMap = true)
public class SurveyQuestionnaire {

    @ApiModelProperty(value = "问卷表id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "问卷标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "问卷表的类型")
    @TableField(value = "type")
    private String type;

    @ApiModelProperty(value = "问卷描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "问题的个数")
    @TableField(exist = false)
    private int total;

    @ApiModelProperty(value = "问卷状态，0：未投递，1：已投递，2：已截止")
    @TableField(value = "status")
    private int status;

    @ApiModelProperty(value = "问卷创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "问卷截止时间")
    @TableField(value = "end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "问卷表对应模板库的id")
    @TableField(value = "template_id")
    private int tempId;

    @ApiModelProperty(value = "问卷的问题集合")
    @TableField(exist = false)
    private List<SurveyQuestionOption> surveyQuestionOptionList;

}

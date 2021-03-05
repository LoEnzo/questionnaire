package com.freefly.questionnaire.vo;

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
public class SurveyQuestionnaire {

    @ApiModelProperty(value = "问卷表id")
    private int id;

    @ApiModelProperty(value = "问卷标题")
    private String title;

    @ApiModelProperty(value = "问卷表的类型")
    private String type;

    @ApiModelProperty(value = "问卷描述")
    private String description;

    @ApiModelProperty(value = "问题的个数")
    private int total;

    @ApiModelProperty(value = "问卷状态，0：未投递，1：已投递，2：已截止")
    private int status;

    @ApiModelProperty(value = "问卷创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "问卷截止时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "问卷表对应模板库的id")
    private int tempId;

    @ApiModelProperty(value = "问卷的问题集合")
    private List<SurveyQuestionOption> surveyQuestionOptionList;

}

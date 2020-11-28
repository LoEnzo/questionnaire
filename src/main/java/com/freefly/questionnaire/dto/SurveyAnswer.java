package com.freefly.questionnaire.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/11/27 10:43
 */
@Getter
@Setter
@Alias("SurveyAnswer")
public class SurveyAnswer {

    @ApiModelProperty(value = "回答人id")
    private int id;

    @ApiModelProperty(value = "回答人填写问卷的id")
    private int questionnaireId;

    @ApiModelProperty(value = "回答人回答问卷的时间")
    private LocalDateTime answerTime;
}

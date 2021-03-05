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
 * @Date2020/11/27 9:59
 */
@Getter
@Setter
@Alias("SurveyAnswerOption")
public class SurveyAnswerOption {

    @ApiModelProperty(value = "答案的id")
    private int id;

    @ApiModelProperty(value = "答案的文本")
    private String context;

    @ApiModelProperty(value = "开放性答案的文本")
    private String other_context;

    @ApiModelProperty(value = "答案的排序")
    private int sort;
}

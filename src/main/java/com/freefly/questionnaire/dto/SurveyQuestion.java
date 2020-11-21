package com.freefly.questionnaire.dto;

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
 * @Date2020/11/21 23:19
 */
@Getter
@Setter
@Alias("SurveyQuestion")
public class SurveyQuestion {

    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "问题")
    private String title;

    @ApiModelProperty(value = "问题的类型")
    private String type;

    @ApiModelProperty(value = "问题的排序")
    private int sort;

    @ApiModelProperty(value = "问题是否必填，0：非必填，1：必填")
    private int optional;
}

package com.freefly.questionnaire.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * ProjectName:
 * ClassName:
 * Class Description:
 *
 * @Author hjwu
 * @Date2020/12/4 10:37
 */
@Getter
@Setter
@Alias("SurveyQuestionnaireTemplate")
public class SurveyQuestionnaireTemplate {

    @ApiModelProperty(value = "问卷表模板库的id")
    private int id;

    @ApiModelProperty(value = "问卷模板的名称")
    private String name;

    @ApiModelProperty(value = "问卷表的排序")
    private int sort;

    @ApiModelProperty(value = "问卷表id")
    private int questionnaire_id;

    @ApiModelProperty(value = "问卷表模板的使用人数")
    private int userNumber;

    @ApiModelProperty(value = "问卷表模板库的问卷")
    private List<SurveyQuestionnaire> surveyQuestionnaireList;
}

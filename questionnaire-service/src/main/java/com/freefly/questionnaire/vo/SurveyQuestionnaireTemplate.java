package com.freefly.questionnaire.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "survey_questionnaire_template", autoResultMap = true)
public class SurveyQuestionnaireTemplate {

    @ApiModelProperty(value = "问卷表模板库的id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "问卷模板的名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "问卷表的排序")
    @TableField(value = "sort")
    private int sort;

    @ApiModelProperty(value = "问卷表id")
    @TableField(value = "questionnaire_id")
    private int questionnaireId;

    @ApiModelProperty(value = "问卷表模板的使用人数")
    @TableField(value = "user_number")
    private int userNumber;

    @TableField(exist = false)
    @ApiModelProperty(value = "问卷表模板库的问卷")
    private List<SurveyQuestionnaire> surveyQuestionnaireList;
}

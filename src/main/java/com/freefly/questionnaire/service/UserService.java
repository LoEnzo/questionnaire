package com.freefly.questionnaire.service;

import com.freefly.questionnaire.vo.SurveyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserService {

    void addUser(SurveyUser surveyUser);

    SurveyUser queryUser(int id);

    void updateUser(SurveyUser user);

    List<SurveyUser> queryAllUser();
}

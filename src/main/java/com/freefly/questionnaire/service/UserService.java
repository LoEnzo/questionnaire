package com.freefly.questionnaire.service;

import com.freefly.questionnaire.dto.SurveyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserService {

    void addUser(SurveyUser surveyUser);

    SurveyUser queryUser(int id);

    void updateUser(SurveyUser user);
}

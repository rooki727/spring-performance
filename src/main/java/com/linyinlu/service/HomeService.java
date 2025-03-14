package com.linyinlu.service;

import com.linyinlu.entity.HomeTotalCount;

import java.util.List;

public interface HomeService {
    HomeTotalCount findUserCount();
    HomeTotalCount findIndicatorsCount();
    HomeTotalCount findAssessmentCount();
    HomeTotalCount findSelfAssessmentCount();
    List<HomeTotalCount> findAcademyCount();
    List<HomeTotalCount> findIndicatorsScore();
}

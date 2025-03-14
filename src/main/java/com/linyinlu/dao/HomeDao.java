package com.linyinlu.dao;

import com.linyinlu.entity.HomeTotalCount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDao {
    HomeTotalCount findUserCount();
    HomeTotalCount findIndicatorsCount();
    HomeTotalCount findAssessmentCount();
    HomeTotalCount findSelfAssessmentCount();
    List<HomeTotalCount> findAcademyCount();
    List<HomeTotalCount> findIndicatorsScore();

}

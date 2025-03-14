package com.linyinlu.service.impl;

import com.linyinlu.dao.HomeDao;
import com.linyinlu.entity.HomeTotalCount;
import com.linyinlu.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public HomeTotalCount findUserCount() {
        return homeDao.findUserCount();
    }

    @Override
    public HomeTotalCount findIndicatorsCount() {
        return homeDao.findIndicatorsCount();
    }

    @Override
    public HomeTotalCount findAssessmentCount() {
        return homeDao.findAssessmentCount();
    }

    @Override
    public HomeTotalCount findSelfAssessmentCount() {
        return homeDao.findSelfAssessmentCount();
    }

    @Override
    public List<HomeTotalCount> findAcademyCount() {
        return homeDao.findAcademyCount();
    }

    @Override
    public List<HomeTotalCount> findIndicatorsScore() {
        return homeDao.findIndicatorsScore();
    }


}

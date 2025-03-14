package com.linyinlu.service.impl;

import com.linyinlu.dao.SelfAssessmentDao;
import com.linyinlu.entity.AssessmentUserIndicators;
import com.linyinlu.entity.SelfAssessment;
import com.linyinlu.service.SelfAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfPerformanceService")
public class SelfAssessmentServiceImpl implements SelfAssessmentService {
    @Autowired
    private SelfAssessmentDao selfAssessmentDao;
    @Override
    public List<AssessmentUserIndicators> findAllSelfAssessment() {
        return selfAssessmentDao.findAllSelfAssessment();
    }

    @Override
    public List<AssessmentUserIndicators> findAllSelfAssessmentByUserId(int user_id) {
        return selfAssessmentDao.findAllSelfAssessmentByUserId(user_id);
    }

    @Override
    public void addSelfAssessment(SelfAssessment selfAssessment) {
        selfAssessmentDao.addSelfAssessment(selfAssessment);
    }

    @Override
    public void updateSelfAssessment(SelfAssessment selfAssessment) {
        selfAssessmentDao.updateSelfAssessment(selfAssessment);
    }

    @Override
    public void deleteSelfAssessment(int self_assessment_id) {
        selfAssessmentDao.deleteSelfAssessment(self_assessment_id);
    }

    @Override
    public void updateSelfAssessType(SelfAssessment selfAssessment) {
        selfAssessmentDao.updateSelfAssessType(selfAssessment);
    }

    @Override
    public void deleteSelfAssessmentScheduled() {
        selfAssessmentDao.deleteSelfAssessmentScheduled();
    }

}

package com.linyinlu.service.impl;

import com.linyinlu.dao.AssessmentDao;
import com.linyinlu.entity.Assessment;
import com.linyinlu.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssessmentService")
public class AssessmentServiceImpl implements AssessmentService {
    @Autowired
    private AssessmentDao assessmentDao;
    @Override
    public void addAssessment(Assessment assessment) {
        assessmentDao.addAssessment(assessment);
    }

    @Override
    public List<Assessment> findAssessmentById(int performance_id) {
        return assessmentDao.findAssessmentById(performance_id);
    }

    @Override
    public void updateAssessmentById(Assessment assessment) {
        assessmentDao.updateAssessmentById(assessment);
    }

    @Override
    public void deleteAssessment(int assessment_id) {
        assessmentDao.deleteAssessment(assessment_id);
    }

}

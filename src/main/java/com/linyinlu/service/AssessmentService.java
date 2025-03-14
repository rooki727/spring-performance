package com.linyinlu.service;

import com.linyinlu.entity.Assessment;

import java.util.List;

public interface AssessmentService {
    void addAssessment(Assessment assessment);
    List<Assessment> findAssessmentById(int performance_id);
    void updateAssessmentById(Assessment assessment);
    void deleteAssessment(int assessment_id);
}

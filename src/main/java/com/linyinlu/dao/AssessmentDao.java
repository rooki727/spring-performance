package com.linyinlu.dao;

import com.linyinlu.entity.Assessment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentDao {
    void addAssessment(Assessment assessment);
    List<Assessment> findAssessmentById(int performance_id);
    void updateAssessmentById(Assessment assessment);
    void deleteAssessment(int assessment_id);
}

package com.linyinlu.service;

import com.linyinlu.entity.AssessmentUserIndicators;
import com.linyinlu.entity.SelfAssessment;

import java.util.List;

public interface SelfAssessmentService {
    List<AssessmentUserIndicators> findAllSelfAssessment();
    List<AssessmentUserIndicators> findAllSelfAssessmentByUserId(int user_id);
    void addSelfAssessment(SelfAssessment selfAssessment);
    void updateSelfAssessment(SelfAssessment selfAssessment);
    void deleteSelfAssessment(int self_assessment_id);
    void updateSelfAssessType(SelfAssessment selfAssessment);
    void deleteSelfAssessmentScheduled();
}

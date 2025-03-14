package com.linyinlu.dao;

import com.linyinlu.entity.AssessmentUserIndicators;
import com.linyinlu.entity.SelfAssessment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelfAssessmentDao {
    List<AssessmentUserIndicators> findAllSelfAssessment();
    List<AssessmentUserIndicators> findAllSelfAssessmentByUserId(int user_id);
    void addSelfAssessment(SelfAssessment selfAssessment);
    void updateSelfAssessment(SelfAssessment selfAssessment);
    void deleteSelfAssessment(int self_assessment_id);
    void updateSelfAssessType(SelfAssessment selfAssessment);
    @Delete("DELETE FROM self_assessment WHERE assess_type = '已评定' AND update_date < NOW() - INTERVAL 30 DAY")
    void deleteSelfAssessmentScheduled();
}

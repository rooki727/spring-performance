package com.linyinlu.service;

import com.linyinlu.entity.AcademyPerformance;
import com.linyinlu.entity.Assessment;
import com.linyinlu.entity.AssessmentPerformance;
import com.linyinlu.entity.TeacherPerformance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeaPerforService {
    void addSelfAssessment(TeacherPerformance teacherPerformance);
    int getLastInsertedId();
    void updateTotalScore(TeacherPerformance teacherPerformance);
    TeacherPerformance isHaveAssessment(int user_id);
    List<AssessmentPerformance> getPerformancesAssessments(@Param("limit") int limit, @Param("offset") int offset,@Param("real_name") String real_name);
    List<AssessmentPerformance> getPerformancesAssessmentsNow(@Param("limit") int limit, @Param("offset") int offset,@Param("real_name") String real_name);
    List<AssessmentPerformance> getPerformancesAssessmentsById(@Param("user_id") int user_id);
    int getTotalCount(@Param("real_name") String real_name);
    void setTotalScore(TeacherPerformance teacherPerformance);
    int getTotalCountNow(@Param("real_name") String real_name);
    void deleteTeacherPerformance(int performance_id);
    List<AcademyPerformance> getAcademyUserStatistics();

}

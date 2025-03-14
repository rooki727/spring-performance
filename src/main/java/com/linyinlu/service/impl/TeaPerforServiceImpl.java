package com.linyinlu.service.impl;

import com.linyinlu.dao.TeaPerforDao;
import com.linyinlu.entity.AcademyPerformance;
import com.linyinlu.entity.Assessment;
import com.linyinlu.entity.AssessmentPerformance;
import com.linyinlu.entity.TeacherPerformance;
import com.linyinlu.service.TeaPerforService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeaPerforService")
public class TeaPerforServiceImpl implements TeaPerforService {
    @Autowired
    private TeaPerforDao teaPerforDao;
    @Override
    public void addSelfAssessment(TeacherPerformance teacherPerformance) {
        teaPerforDao.addSelfAssessment(teacherPerformance);
    }

    @Override
    public int getLastInsertedId() {
        return teaPerforDao.getLastInsertedId();
    }

    @Override
    public void updateTotalScore(TeacherPerformance teacherPerformance) {
        teaPerforDao.updateTotalScore(teacherPerformance);
    }
    @Override
    public TeacherPerformance isHaveAssessment(int user_id) {
        return teaPerforDao.isHaveAssessment(user_id);
    }

    @Override
    public List<AssessmentPerformance> getPerformancesAssessments(@Param("limit") int limit, @Param("offset") int offset,@Param("real_name") String real_name) {
        return teaPerforDao.getPerformancesAssessments(limit,offset,real_name);
    }

    @Override
    public List<AssessmentPerformance> getPerformancesAssessmentsNow(int limit, int offset, String real_name) {
        return teaPerforDao.getPerformancesAssessmentsNow(limit,offset,real_name);
    }

    @Override
    public List<AssessmentPerformance> getPerformancesAssessmentsById( int user_id) {
        return teaPerforDao.getPerformancesAssessmentsById(user_id);
    }

    @Override
    public int getTotalCount(@Param("real_name") String real_name) {
        return teaPerforDao.getTotalCount(real_name);
    }

    @Override
    public void setTotalScore(TeacherPerformance teacherPerformance) {
        teaPerforDao.setTotalScore(teacherPerformance);
    }

    @Override
    public int getTotalCountNow(String real_name) {
        return teaPerforDao.getTotalCountNow(real_name);
    }

    @Override
    public void deleteTeacherPerformance(int performance_id) {
        teaPerforDao.deleteTeacherPerformance(performance_id);
    }

    @Override
    public List<AcademyPerformance> getAcademyUserStatistics() {
        return teaPerforDao.getAcademyUserStatistics();
    }


}

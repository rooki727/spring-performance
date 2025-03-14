package com.linyinlu.controller;

import com.linyinlu.entity.*;
import com.linyinlu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/managerAssessment")
public class ManagerAssessmentController {
    @Autowired
    private SelfAssessmentService selfAssessmentService;
    @Autowired
    private IUserService userService;
    @Autowired
    private TeaPerforService teaPerforService;
    @Autowired
    private IndicatorsService indicatorsService;
    @Autowired
    private AssessmentService assessmentService;
    @PostMapping("/manageAssessment")
    @ResponseBody
    public ApiResponse<Boolean> manageAssessment(@RequestBody AssessmentPerformance assessmentPerformance, HttpServletRequest request){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        String tokenRefresh = request.getHeader("Refreshtoken");
        Assessment selfAssessment = assessmentPerformance.getAssessmentList().get(0);
        Assessment assessment = assessmentPerformance.getAssessmentList().get(1);
        User user=userService.selectUserByRefreshToken(tokenRefresh);
        try {
            if(user.toString().isEmpty()){
                apiResponse.setCode("-403");
                apiResponse.setMsg("你无权限操作;请重新登录校验");
            }
            else{
                int performance_id=0;
//判断当前季度是否已经有过评定
                TeacherPerformance assessmentCheck=teaPerforService.isHaveAssessment(assessmentPerformance.getUser_id());
                TeacherPerformance teacherPerformance =new TeacherPerformance();
                teacherPerformance.setUser_id(assessmentPerformance.getUser_id());
                if(assessmentCheck!=null){
                    performance_id=assessmentCheck.getPerformance_id();
                }
                else{
                    teaPerforService.addSelfAssessment(teacherPerformance);
                    performance_id= teaPerforService.getLastInsertedId();
                }
                teacherPerformance.setPerformance_id(performance_id);
                selfAssessment.setPerformance_id(performance_id);
                assessment.setPerformance_id(performance_id);
//                存入历史评定表
                assessmentService.addAssessment(selfAssessment);
                assessmentService.addAssessment(assessment);
                Indicators indicators = indicatorsService.findIndicatorByIndicatorId(selfAssessment.getIndicator_id());
                Double weight = indicators.getWeight();
                Double total_score=(weight * selfAssessment.getScore() + weight * assessment.getScore())/2;
                System.out.println(total_score);
                teacherPerformance.setTotal_score(total_score);
//                存入总分数
                teaPerforService.updateTotalScore(teacherPerformance);
                //                更新状态
                SelfAssessment selfAssessmentNeed = new SelfAssessment();
                selfAssessmentNeed.setIndicator_id(selfAssessment.getIndicator_id());
                selfAssessmentNeed.setUser_id(assessmentPerformance.getUser_id());
                selfAssessmentNeed.setAssess_type("已评定");
                selfAssessmentService.updateSelfAssessType(selfAssessmentNeed);
                apiResponse.setCode("1");
                apiResponse.setMsg("评定成功");
                apiResponse.setData(true);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return apiResponse;
    }

    @PostMapping("/getAssessmentById")
    @ResponseBody
    public ApiResponse<List<Assessment>> getAssessmentById(@RequestBody Assessment assessment){
        ApiResponse<List<Assessment>> listApiResponse = new ApiResponse<>();
        try {
            List<Assessment> assessmentList =assessmentService.findAssessmentById(assessment.getPerformance_id());
            listApiResponse.setCode("1");
            listApiResponse.setMsg("评定成功");
            listApiResponse.setData(assessmentList);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return listApiResponse;
    }

    @PostMapping("/updateAssessment")
    @ResponseBody
    public ApiResponse<Boolean> updateAssessment(@RequestBody Assessment assessment, HttpServletRequest request){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        String tokenRefresh = request.getHeader("Refreshtoken");
        User user=userService.selectUserByRefreshToken(tokenRefresh);
        try {
            if(user.toString().isEmpty()){
                apiResponse.setCode("-403");
                apiResponse.setMsg("你无权限操作;请重新登录校验");
            }
            else{
                assessmentService.updateAssessmentById(assessment);
                resetTotalScore(assessment, apiResponse);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return apiResponse;
    }
    @PostMapping("/deleteAssessment")
    @ResponseBody
    public ApiResponse<Boolean> deleteAssessment(@RequestBody Assessment assessment, HttpServletRequest request){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        String tokenRefresh = request.getHeader("Refreshtoken");
        User user=userService.selectUserByRefreshToken(tokenRefresh);
        try {
            if(user.toString().isEmpty()){
                apiResponse.setCode("-403");
                apiResponse.setMsg("你无权限操作;请重新登录校验");
            }
            else{
                assessmentService.deleteAssessment(assessment.getAssessment_id());
                resetTotalScore(assessment, apiResponse);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return apiResponse;
    }

    private void resetTotalScore(@RequestBody Assessment assessment, ApiResponse<Boolean> apiResponse) {
        List<Assessment> list=assessmentService.findAssessmentById(assessment.getPerformance_id());
        Double total_score = 0.0;
        for(Assessment assessmentNew :list){
            Indicators indicators = indicatorsService.findIndicatorByIndicatorId(assessmentNew.getIndicator_id());
            Double weight = indicators.getWeight();
            total_score = total_score + (assessmentNew.getScore() * weight)/2;
            System.out.println(total_score);
        }
        TeacherPerformance teacherPerformance = new TeacherPerformance();
        teacherPerformance.setPerformance_id(assessment.getPerformance_id());
        teacherPerformance.setTotal_score(total_score);
        teaPerforService.setTotalScore(teacherPerformance);
        apiResponse.setCode("1");
        apiResponse.setMsg("评定成功");
        apiResponse.setData(true);
    }
}

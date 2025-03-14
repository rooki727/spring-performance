package com.linyinlu.controller;

import com.linyinlu.entity.*;
import com.linyinlu.service.AssessmentService;
import com.linyinlu.service.IUserService;
import com.linyinlu.service.TeaPerforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Controller
@RequestMapping("/assessmentPerformance")
public class AssessmentPerformanceController {
    @Autowired
    private TeaPerforService teaPerforService;
    @Autowired
    private AssessmentService assessmentService;
    @Autowired
    private IUserService userService;
    @GetMapping("/findAllPerformance")
    @ResponseBody
    public ApiResponse<List<AssessmentPerformance>> findAllPerformance(@RequestParam(defaultValue = "1") int page,
                                                                       @RequestParam(defaultValue = "10") int size,
                                                                       @RequestParam(required = false) String real_name) {
        // 计算分页的 offset
        int offset = (page - 1) * size;
        ApiResponse<List<AssessmentPerformance>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的 assessmentPerformance 数据
            List<AssessmentPerformance> assessmentPerformanceList = teaPerforService.getPerformancesAssessments(size, offset,real_name);
            // 对每个 AssessmentPerformance 填充其对应的 Assessment 数据
            for (AssessmentPerformance assessmentPerformance : assessmentPerformanceList) {
                List<Assessment> assessmentList = assessmentService.findAssessmentById(assessmentPerformance.getPerformance_id());
                assessmentPerformance.setAssessmentList(assessmentList);
            }
            // 获取总记录数以计算总页数
            int totalPage=teaPerforService.getTotalCount(real_name);
            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setTotalCount(totalPage);
            listApiResponse.setData(assessmentPerformanceList);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }
    @GetMapping("/findAllPerformanceNow")
    @ResponseBody
    public ApiResponse<List<AssessmentPerformance>> findAllPerformanceNow(@RequestParam(defaultValue = "1") int page,
                                                                       @RequestParam(defaultValue = "10") int size,
                                                                       @RequestParam(required = false) String real_name) {
        // 计算分页的 offset
        int offset = (page - 1) * size;
        ApiResponse<List<AssessmentPerformance>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的 assessmentPerformance 数据
            List<AssessmentPerformance> assessmentPerformanceList = teaPerforService.getPerformancesAssessmentsNow(size, offset,real_name);
            // 对每个 AssessmentPerformance 填充其对应的 Assessment 数据
            for (AssessmentPerformance assessmentPerformance : assessmentPerformanceList) {
                List<Assessment> assessmentList = assessmentService.findAssessmentById(assessmentPerformance.getPerformance_id());
                assessmentPerformance.setAssessmentList(assessmentList);
            }
            // 获取总记录数以计算总页数
            int totalPage=teaPerforService.getTotalCountNow(real_name);
            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setTotalCount(totalPage);
            listApiResponse.setData(assessmentPerformanceList);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }

    @GetMapping("/getPerformancesAssessmentsById")
    @ResponseBody
    public ApiResponse<List<AssessmentPerformance>> getPerformancesAssessmentsById(@RequestParam int user_id){
        ApiResponse<List<AssessmentPerformance>> listApiResponse = new ApiResponse<>();
        List<AssessmentPerformance> assessmentPerformanceList =new ArrayList<>();
        try {
            assessmentPerformanceList =teaPerforService.getPerformancesAssessmentsById(user_id);
            for (AssessmentPerformance assessmentPerformance : assessmentPerformanceList) {
                List<Assessment> assessmentList =new ArrayList<>();
                assessmentList=assessmentService.findAssessmentById(assessmentPerformance.getPerformance_id());
                assessmentPerformance.setAssessmentList(assessmentList);
                assessmentList=new ArrayList<>();
            }
            int totalPage=teaPerforService.getTotalCount("");
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setTotalCount(totalPage);
            listApiResponse.setData(assessmentPerformanceList);
            return listApiResponse;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/deleteTeacherPerformance")
    @ResponseBody
    public ApiResponse<Boolean> deleteTeacherPerformance(@RequestParam int performance_id, HttpServletRequest request){
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        String tokenRefresh = request.getHeader("Refreshtoken");
        User user=userService.selectUserByRefreshToken(tokenRefresh);
        try {
            if(user.toString().isEmpty()){
                apiResponse.setCode("-403");
                apiResponse.setMsg("你无权限操作;请重新登录校验");
            }
            else{
                teaPerforService.deleteTeacherPerformance(performance_id);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return apiResponse;
    }
    @GetMapping("/getAcademyUserStatistics")
    @ResponseBody
    public ApiResponse<List<AcademyPerformance>> getAcademyUserStatistics() {
        // 计算分页的 offset
        ApiResponse<List<AcademyPerformance>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的 assessmentPerformance 数据
            List<AcademyPerformance> academyPerformanceList = teaPerforService.getAcademyUserStatistics();
            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setData(academyPerformanceList);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }
}

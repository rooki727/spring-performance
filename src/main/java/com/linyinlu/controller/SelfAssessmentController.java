package com.linyinlu.controller;

import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.AssessmentUserIndicators;
import com.linyinlu.entity.SelfAssessment;
import com.linyinlu.service.SelfAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/selfAssessment")
public class SelfAssessmentController {
    @Autowired
    private SelfAssessmentService selfAssessmentService;

    @GetMapping("/findAllSelfAssessment")
    @ResponseBody
    public ApiResponse<List<AssessmentUserIndicators>> findAllSelfAssessment(){
        ApiResponse<List<AssessmentUserIndicators>> listApiResponse = new ApiResponse<>();
        //调用service的方法
        try {
            List<AssessmentUserIndicators> selfAssessmentList = selfAssessmentService.findAllSelfAssessment();
            listApiResponse.setData(selfAssessmentList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/findAllSelfAssessmentByUserId")
    @ResponseBody
    public ApiResponse<List<AssessmentUserIndicators>> findAllSelfAssessmentByUserId(@RequestBody Map<String, Object> requestBody){
        ApiResponse<List<AssessmentUserIndicators>> listApiResponse = new ApiResponse<>();
        //调用service的方法
        // 从请求体中获取 user_id
        int id = (int) requestBody.get("user_id");
        try {
            List<AssessmentUserIndicators> selfAssessmentList = selfAssessmentService.findAllSelfAssessmentByUserId(id);
            listApiResponse.setData(selfAssessmentList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/addSelfAssessment")
    @ResponseBody
    public ApiResponse<Boolean> addSelfAssessment(@RequestBody SelfAssessment selfAssessment) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        try{
            selfAssessmentService.addSelfAssessment(selfAssessment);
            apiResponse.setCode("1");
            apiResponse.setMsg("成功添加");
            apiResponse.setData(true);
        }catch (Exception e){
            apiResponse.setCode("-1");
            apiResponse.setMsg(e.toString());
            throw new RuntimeException(e);
        }
        return apiResponse;
    }
    //    修改
    @PostMapping("/updateSelfAssessment")
    @ResponseBody
    public ApiResponse<Boolean> updateSelfAssessment(@RequestBody SelfAssessment selfAssessment) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        try{
            selfAssessmentService.updateSelfAssessment(selfAssessment);
            apiResponse.setCode("1");
            apiResponse.setMsg("成功修改");
            apiResponse.setData(true);
        }catch (Exception e){
            apiResponse.setCode("-1");
            apiResponse.setMsg(e.toString());
            throw new RuntimeException(e);
        }
        return apiResponse;
    }
    //删
    @PostMapping("/deleteSelfAssessment")
    @ResponseBody
    public  ApiResponse<Boolean> deleteSelfAssessment(@RequestBody Map<String, Object> requestBody) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 从请求体中获取 self_assessment_id
        int id = (int) requestBody.get("self_assessment_id");
        try {
            selfAssessmentService.deleteSelfAssessment(id);
            response.setCode("1");
            response.setMsg("操作成功");
            response.setData(true);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

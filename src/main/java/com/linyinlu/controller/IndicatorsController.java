package com.linyinlu.controller;

import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.Indicators;
import com.linyinlu.entity.User;
import com.linyinlu.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/indicators")
public class IndicatorsController {
    @Autowired
    private IndicatorsService indicatorsService;
    @GetMapping("/findAllIndicators")
    @ResponseBody
    public ApiResponse<List<Indicators>> findAllIndicators(){
        ApiResponse<List<Indicators>> listApiResponse = new ApiResponse<>();
        //调用service的方法
        try {
            List<Indicators> indicatorsList = indicatorsService.findAllIndicators();
            listApiResponse.setData(indicatorsList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @PostMapping("/addIndicators")
    @ResponseBody
    public ApiResponse<Boolean> addIndicators(@RequestBody Indicators indicators) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        try{
            indicatorsService.addIndicators(indicators);
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
    @PostMapping("/updateIndicators")
    @ResponseBody
    public ApiResponse<Boolean> updateIndicators(@RequestBody Indicators indicators) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        try{
            indicatorsService.updateIndicators(indicators);
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
    //删
    @PostMapping("/deleteIndicators")
    @ResponseBody
    public  ApiResponse<Boolean> deleteIndicators(@RequestBody Map<String, Object> requestBody) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 从请求体中获取 userId
        int id = (int) requestBody.get("indicator_id");
        try {
            indicatorsService.deleteIndicators(id);
            response.setCode("1");
            response.setMsg("操作成功");
            response.setData(true);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

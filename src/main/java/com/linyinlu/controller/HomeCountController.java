package com.linyinlu.controller;

import com.linyinlu.entity.AcademyPerformance;
import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.HomeTotalCount;
import com.linyinlu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/home")
public class HomeCountController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/getTotalCount")
    @ResponseBody
    public ApiResponse<List<HomeTotalCount>> getTotalCount() {
        // 计算分页的 offset
        ApiResponse<List<HomeTotalCount>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的统计数据
            // 创建一个列表，直接存储所有的 HomeTotalCount 对象
            List<HomeTotalCount> list = new ArrayList<>();

            HomeTotalCount usersCount = homeService.findUserCount();
            usersCount.setHome_name("总教师数量");
            list.add(usersCount);

            HomeTotalCount indicatorsCount = homeService.findIndicatorsCount();
            indicatorsCount.setHome_name("本季度指标数量");
            list.add(indicatorsCount);

            HomeTotalCount teaPerCount = homeService.findAssessmentCount();
            teaPerCount.setHome_name("本月已评绩效");
            list.add(teaPerCount);

            HomeTotalCount selfCount = homeService.findSelfAssessmentCount();
            selfCount.setHome_name("本月已自评绩效");
            list.add(selfCount);

            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setData(list);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }
    @GetMapping("/getAcademyCount")
    @ResponseBody
    public ApiResponse<List<HomeTotalCount>> getAcademyCount() {
        // 计算分页的 offset
        ApiResponse<List<HomeTotalCount>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的统计数据
            // 创建一个列表，直接存储所有的 HomeTotalCount 对象
            List<HomeTotalCount> list = homeService.findAcademyCount();

            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setData(list);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }

    @GetMapping("/findIndicatorsScore")
    @ResponseBody
    public ApiResponse<List<HomeTotalCount>> findIndicatorsScore() {
        // 计算分页的 offset
        ApiResponse<List<HomeTotalCount>> listApiResponse = new ApiResponse<>();

        try {
            // 获取所有的统计数据
            // 创建一个列表，直接存储所有的 HomeTotalCount 对象
            List<HomeTotalCount> list = homeService.findIndicatorsScore();

            // 设置响应数据
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询成功！");
            listApiResponse.setData(list);

            return listApiResponse;
        } catch (Exception e) {
            // 可以更具体的捕获异常并返回相应错误信息
            listApiResponse.setCode("0");
            listApiResponse.setMsg("查询失败：" + e.getMessage());
            return listApiResponse;
        }
    }
}

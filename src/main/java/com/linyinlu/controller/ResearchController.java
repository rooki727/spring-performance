package com.linyinlu.controller;

import com.linyinlu.dao.ResearchDao;
import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/research")
public class ResearchController {
    @Autowired
    private ResearchDao researchDao;

    @GetMapping("/getAllResearch")
    @ResponseBody
    public ApiResponse<List<Research>> getAllResearch(){
        ApiResponse<List<Research>> listApiResponse = new ApiResponse<>();
        try {
            List<Research> researchList = researchDao.getAllResearch();
            listApiResponse.setData(researchList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @GetMapping("/getResearchByUser")
    @ResponseBody
    public ApiResponse<List<Research>> getResearchByUser(@RequestParam int user_id){
        ApiResponse<List<Research>> listApiResponse = new ApiResponse<>();
        try {
            List<Research> researchList = researchDao.getResearchByUser(user_id);
            listApiResponse.setData(researchList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/deleteResearch")
    @ResponseBody
    public ApiResponse<Boolean> deleteResearch(@RequestParam int research_id){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            researchDao.deleteResearch(research_id);
            listApiResponse.setData(true);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @PostMapping("/addResearch")
    @ResponseBody
    public ApiResponse<Boolean> addResearch(@RequestBody Research research){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            researchDao.addResearch(research);
            listApiResponse.setData(true);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/updateResearch")
    @ResponseBody
    public ApiResponse<Boolean> updateResearch(@RequestBody Research research){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            researchDao.updateResearch(research);
            listApiResponse.setData(true);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @PostMapping("/checkStatus")
    @ResponseBody
    public ApiResponse<Boolean> checkStatus(@RequestBody Research research){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            researchDao.checkStatus(research);
            listApiResponse.setData(true);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
}

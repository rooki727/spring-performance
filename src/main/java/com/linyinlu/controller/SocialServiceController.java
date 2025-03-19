package com.linyinlu.controller;

import com.linyinlu.dao.SocialServiceDao;
import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/socialService")
public class SocialServiceController {
    @Autowired
    private SocialServiceDao socialServiceDao;

    @GetMapping("/getAllSocial")
    @ResponseBody
    public ApiResponse<List<SocialService>> getAllSocial(){
        ApiResponse<List<SocialService>> listApiResponse = new ApiResponse<>();
        try {
            List<SocialService> socialServices = socialServiceDao.getAllSocial();
            listApiResponse.setData(socialServices);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @GetMapping("/getSocialByUser")
    @ResponseBody
    public ApiResponse<List<SocialService>> getSocialByUser(@RequestParam int user_id){
        ApiResponse<List<SocialService>> listApiResponse = new ApiResponse<>();
        try {
            List<SocialService> socialServices = socialServiceDao.getSocialByUser(user_id);
            listApiResponse.setData(socialServices);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/deleteSocial")
    @ResponseBody
    public ApiResponse<Boolean> deleteSocial(@RequestParam int service_id){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            socialServiceDao.deleteSocial(service_id);
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

    @PostMapping("/addSocial")
    @ResponseBody
    public ApiResponse<Boolean> addSocial(@RequestBody SocialService socialService){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            socialServiceDao.addSocial(socialService);
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
    @PostMapping("/updateSocial")
    @ResponseBody
    public ApiResponse<Boolean> updateSocial(@RequestBody SocialService socialService){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            socialServiceDao.updateSocial(socialService);
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
    public ApiResponse<Boolean> checkStatus(@RequestBody SocialService socialService){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            socialServiceDao.checkStatus(socialService);
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

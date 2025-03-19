package com.linyinlu.controller;

import com.linyinlu.dao.TeachingTaskDao;
import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.TeachingTask;
import com.linyinlu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/teachingTask")
public class TeachingTaskController {
    @Autowired
    private TeachingTaskDao teachingTaskDao;

    @GetMapping("/getAllTask")
    @ResponseBody
    public ApiResponse<List<TeachingTask>> getAllTask(){
        ApiResponse<List<TeachingTask>> listApiResponse = new ApiResponse<>();
        try {
            List<TeachingTask> taskList = teachingTaskDao.getAllTask();
            listApiResponse.setData(taskList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    @GetMapping("/getTaskByUser")
    @ResponseBody
    public ApiResponse<List<TeachingTask>> getTaskByUser(@RequestParam int user_id){
        ApiResponse<List<TeachingTask>> listApiResponse = new ApiResponse<>();
        try {
            List<TeachingTask> taskList = teachingTaskDao.getTaskByUser(user_id);
            listApiResponse.setData(taskList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
    @PostMapping("/deleteTask")
    @ResponseBody
    public ApiResponse<Boolean> deleteTask(@RequestParam int task_id){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            teachingTaskDao.deleteTask(task_id);
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

    @PostMapping("/addTask")
    @ResponseBody
    public ApiResponse<Boolean> addTask(@RequestBody TeachingTask teachingTask){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            teachingTaskDao.addTask(teachingTask);
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
    @PostMapping("/updateTask")
    @ResponseBody
    public ApiResponse<Boolean> updateTask(@RequestBody TeachingTask teachingTask){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            teachingTaskDao.updateTask(teachingTask);
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
    public ApiResponse<Boolean> checkStatus(@RequestBody TeachingTask teachingTask){
        ApiResponse<Boolean> listApiResponse = new ApiResponse<>();
        try {
            teachingTaskDao.checkStatus(teachingTask);
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

package com.linyinlu.controller;

import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.ConfigSystem;
import com.linyinlu.entity.Indicators;
import com.linyinlu.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping("/getConfig")
    @ResponseBody
    public ApiResponse<ConfigSystem> getConfig(@RequestParam("config_name") String config_name){
        ApiResponse<ConfigSystem> configSystemApiResponse = new ApiResponse<>();
        try {
            ConfigSystem configSystem = configService.findConfigByName(config_name);
            configSystemApiResponse.setCode("1");
            configSystemApiResponse.setMsg("查询配置成功");
            configSystemApiResponse.setData(configSystem);
            return configSystemApiResponse;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/updateConfig")
    @ResponseBody
    public ApiResponse<Boolean> updateConfig(@RequestBody ConfigSystem configSystem){
        ApiResponse<Boolean> configSystemApiResponse = new ApiResponse<>();
        try {
            configService.updateConfig(configSystem);
            configSystemApiResponse.setCode("1");
            configSystemApiResponse.setMsg("查询配置成功");
            configSystemApiResponse.setData(true);
            return configSystemApiResponse;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

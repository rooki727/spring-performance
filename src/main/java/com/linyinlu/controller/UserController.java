package com.linyinlu.controller;

import com.linyinlu.entity.ApiResponse;
import com.linyinlu.entity.CaptchaChar;
import com.linyinlu.entity.User;
import com.linyinlu.jwt.JwtConfig;
import com.linyinlu.service.IUserService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    JwtConfig jwtConfig=new JwtConfig();

    @GetMapping("/findAll")
    @ResponseBody
    public ApiResponse<List<User>> findAll(){
        ApiResponse<List<User>> listApiResponse = new ApiResponse<>();
        System.out.println("表现层--查询所有用户");
        //调用service的方法
        try {
            List<User> userList = userService.findAll();
            listApiResponse.setData(userList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }
//
    @GetMapping("/findAllTeacher")
    @ResponseBody
    public ApiResponse<List<User>> findAllTeacher(){
        ApiResponse<List<User>> listApiResponse = new ApiResponse<>();
        System.out.println("表现层--查询所有用户");
        //调用service的方法
        try {
            List<User> userList = userService.findAllTeacher();
            listApiResponse.setData(userList);
            listApiResponse.setCode("1");
            listApiResponse.setMsg("查询所有教师成功");
        }
        catch (Exception e) {
            listApiResponse.setCode("-1");
            listApiResponse.setMsg(e.toString());
        }
        return listApiResponse;
    }

    //登录
    @PostMapping("/login")
    @ResponseBody
    public ApiResponse<User> login(@RequestBody User user) {
        ApiResponse<User> loginUserRes = new ApiResponse<>();
        User loginUser=userService.selectUserByAccountAndPassword(user);
        try{
            if(loginUser.getPassword().equals(user.getPassword())){
                // 登录成功，生成token和refreshToken
                String token =jwtConfig.createToken(loginUser.getUser_id().toString());
                String refreshToken=jwtConfig.createRefreshToken(loginUser.getUser_id().toString());
                loginUser.setToken(token);
                loginUser.setRefreshToken(refreshToken);
                userService.updateUserToken(loginUser);
                loginUser.setPassword(null);
                loginUserRes.setData(loginUser);
                loginUserRes.setCode("1");
                loginUserRes.setMsg("登录成功");
            }
            else{
                loginUserRes.setCode("-1");
                loginUserRes.setMsg("账号密码错误！请注意选择的角色是否正确！");
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
            loginUserRes.setCode("-1");
            loginUserRes.setMsg("账号密码错误！请注意选择的角色是否正确！");
        }
        return loginUserRes;
    }
    //token无感刷新 user
    @PostMapping("/refreshTokenUser")
    @ResponseBody
    public ResponseEntity<?> refreshTokenUser(@RequestBody User user) {
        User user1=userService.getUserById(user.getUser_id());
        if (user1.getRefreshToken().equals(user.getRefreshToken())) {
            String newAccessToken = jwtConfig.createToken(user.getUser_id().toString());
            user1.setToken(newAccessToken);
            userService.updateUserToken(user1);
            user1.setPassword(null);
            return ResponseEntity.ok(user1);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Refresh Token 已失效");
        }
    }
    @PostMapping("/getUserById")
    @ResponseBody
    public ApiResponse<User> getUserById(@RequestBody Map<String, Object> requestBody){
        ApiResponse<User> response = new ApiResponse<>();
        //        获取id
        int user_id = (int) requestBody.get("user_id");
        try {
            User user=userService.getUserById(user_id);
            response.setCode("1");
            response.setMsg("操作成功");
            user.setPassword(null);
            response.setData(user);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
//    修改个人用户信息
    @PostMapping("/updateUser")
    @ResponseBody
    public  ApiResponse<Boolean> updateUser(@RequestBody User user,HttpServletRequest request) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 获取请求头中的Token
        String tokenAuthorization = request.getHeader("Authorization");
        if (tokenAuthorization.startsWith("Bearer ")) {
            // 获取实际的Token值
            String token = tokenAuthorization.substring(7);
            User oldUser=userService.getUserById(user.getUser_id());// 7是 "Bearer " 的长度
            boolean isToken=  userService.isCommonToken(token,oldUser.getToken());
            if (isToken) {
                boolean isValid = jwtConfig.validateToken(token, user.getUser_id().toString());
                if(!isValid){
                    response.setCode("-403");
                    response.setMsg("token失效");
                    response.setData(false);
                    return response;
                }

                else{
                    System.out.println("token校验成功！updateUser");

                    //    处理业务
                    try {
                        userService.updateUser(user);
                        response.setCode("1");
                        response.setMsg("操作成功");
                        response.setData(true);
                        return response;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
//                    token失效标准code-403
            else{
                response.setCode("-403");
                response.setMsg("token失效");
                response.setData(false);
                return response;
            }
        }
        return response;

    }
    //    检验密码
    @PostMapping("/checkOldPassword")
    @ResponseBody
    public  ApiResponse<Boolean> checkOldPassword(@RequestBody User user,HttpServletRequest request) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 获取请求头中的Token
        String tokenAuthorization = request.getHeader("Authorization");
        if (tokenAuthorization.startsWith("Bearer ")) {
            // 获取实际的Token值
            String token = tokenAuthorization.substring(7);
            User oldUser=userService.getUserById(user.getUser_id());// 7是 "Bearer " 的长度
            boolean isToken=  userService.isCommonToken(token,oldUser.getToken());
            if (isToken) {
                boolean isValid = jwtConfig.validateToken(token, user.getUser_id().toString());
                if(!isValid){
                    response.setCode("-403");
                    response.setMsg("token失效");
                    response.setData(false);
                    return response;
                }

                else{
                    System.out.println("token校验成功！updateUser");

                    //    处理业务
                    try {
                        if(user.getPassword().equals(oldUser.getPassword())){
                            response.setData(true);
                        }
                        else{
                            response.setData(false);
                        }
                        response.setCode("1");
                        response.setMsg("操作成功");
                        return response;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
//                    token失效标准code-403
            else{
                response.setCode("-403");
                response.setMsg("token失效");
                response.setData(false);
                return response;
            }
        }
        return response;

    }
    //    封装一个判断权限的函数
    public Boolean checkVerify(int login_id){
        User user=userService.getUserById(login_id);
        if("admin".equals(user.getRole())){
            System.out.println("权限校验通过！");
            return true;
        }
        else {
            return false;
        }
    }
    //    修改个人用户信息
    @PostMapping("/updateUserByAdmin")
    @ResponseBody
    public  ApiResponse<Boolean> updateUserByAdmin(@RequestBody User user,HttpServletRequest request) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 获取请求头中的Token
        String refreshToken = request.getHeader("RefreshToken");
        if (!refreshToken.isEmpty()) {
            // 获取实际的Token值
            User oldUser=userService.selectUserByRefreshToken(refreshToken);

            if (oldUser.toString().isEmpty()) {
                response.setCode("-403");
                response.setMsg("token失效");
                response.setData(false);
                return response;
            }
                else{
                    System.out.println("refreshToken校验成功！updateUser");
                    //    处理业务
                    try {
                        userService.updateUser(user);
                        response.setCode("1");
                        response.setMsg("操作成功");
                        response.setData(true);
                        return response;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        return response;

    }
//    检验账号是否存在
@PostMapping("/checkUserName")
@ResponseBody
public ApiResponse<Boolean> checkUserName(@RequestBody Map<String, Object> requestBody){
    ApiResponse<Boolean> response = new ApiResponse<>();
    int account = (int) requestBody.get("account");
    User user= userService.checkUserName(account);
    if(user==null){
        response.setCode("1");
        response.setMsg("账号可用");
        response.setData(true);
        return response;
    }
    else {
        response.setCode("-1");
        response.setMsg("账号不可用");
        response.setData(false);
        return response;
    }
}
    //增
    @PostMapping("/addUser")
    @ResponseBody
    public ApiResponse<Boolean> addUser(@RequestBody User user) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        try{
            userService.addUser(user);
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
    @PostMapping("/deleteUser")
    @ResponseBody
    public  ApiResponse<Boolean> deleteUser(@RequestBody Map<String, Object> requestBody,HttpServletRequest request) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 从请求体中获取 userId
        int id = (int) requestBody.get("user_id");
        try {
            userService.deleteUser(id);
            response.setCode("1");
            response.setMsg("操作成功");
            response.setData(true);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/generateCaptcha")
    @ResponseBody
    public  List<CaptchaChar> generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        List<CaptchaChar> captcha = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            char value = chars.charAt(random.nextInt(chars.length()));
            int position = (int) (Math.random() * 10 + 5);
            int rotation = (int) (Math.random() * 40 - 20);

            captcha.add(new CaptchaChar(value, position, rotation));
        }

        return captcha;
    }
}


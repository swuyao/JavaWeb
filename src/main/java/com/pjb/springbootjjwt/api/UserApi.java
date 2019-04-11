package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.service.TokenService;
import com.pjb.springbootjjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

/**
 * @author yc
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("user")//登录
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);

        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                // String role=user.getRole();
                String token = tokenService.getToken(userForBase);
                userService.updatetoken(user.getId(),token);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                //System.out.println(user.getRole());
                return jsonObject;
            }
        }
    }


    @UserLoginToken
    @PostMapping("/a")//测试token
    public Object insertoneuser() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "測試成功");
        return jsonObject;
    }

    @UserLoginToken
    @PostMapping("/adduser")//注册用户
    public boolean adduser(@RequestBody User user) {
        System.out.print("添加用户");
        boolean result;
        result = userService.adduser(user);
        System.out.println(result);
        return result;
    }



/***
    @UserLoginToken
    @PostMapping("/import")//excel导入用户信息
    public Object addUser(@RequestParam("file") MultipartFile file) {
        boolean a = false;
        Object jsonObject = new JSONObject();
        String fileName = file.getOriginalFilename();
        try {
            jsonObject = userService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jsonObject;
    }


**/









}
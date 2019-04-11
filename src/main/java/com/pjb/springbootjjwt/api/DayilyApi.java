package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pjb.springbootjjwt.annotation.PassToken;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Dayily;
import com.pjb.springbootjjwt.mapper.DayilyMapper;
import com.pjb.springbootjjwt.service.DayilyService;
import com.pjb.springbootjjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yc
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("dayily")

public class DayilyApi {
    @Autowired
    DayilyService dayilyService;




    @UserLoginToken
    //@PassToken
    @PostMapping("/ShowTodayData")
    public Dayily ShowTodayData(){
        return dayilyService.ShowTodayData();
    }

    @UserLoginToken
    //@PassToken
    @PostMapping("/Update")
    public boolean Update(@RequestBody Dayily dayily){return dayilyService.Update(dayily);};

    @UserLoginToken
    //@PassToken
    @PostMapping("/Sum")
    public Map<String,BigDecimal> Sum(){return dayilyService.sum();};

    @UserLoginToken
    //@PassToken
    @PostMapping("/ShowAllDiary")
    public List<Dayily> ShowAllDiary(){return dayilyService.ShowAllDiary();};



}
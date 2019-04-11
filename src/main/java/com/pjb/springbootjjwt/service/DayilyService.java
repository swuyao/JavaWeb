package com.pjb.springbootjjwt.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pjb.springbootjjwt.mapper.DayilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yc
 * @date 2018-07-08 20:52
 */
@Service("DayilyService")
public class DayilyService {
    @Autowired
    DayilyMapper dayilyMapper;


    public List<Notice> showNoticeByRole(String role){return noticeMapper.showNoticeByRole(role);};

    public  Map<String, Object> findAllTitle(int pageNum, int pageSize) throws Exception{

        Page page=PageHelper.startPage(pageNum, pageSize,true);
        List<Notice> titlelist=noticeMapper.findAllTitle();
        System.out.println(titlelist);
        Map<String,Object> map=new HashMap<>();
        map.put("code" ,0);
        System.out.print(page.getTotal());
        map.put("count", page.getTotal());
        map.put("nowPage", pageNum);
        map.put("data", titlelist);
        return map;

    }
    public Notice findByTitle(String title){return noticeMapper.findByTitle(title);}


    public Notice findNewestNotice(){

        return noticeMapper.findNewestNotice();};
    public boolean deleteNotice(String title){return noticeMapper.deleteNotice(title);}





}

package com.pjb.springbootjjwt.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pjb.springbootjjwt.entity.Dayily;
import com.pjb.springbootjjwt.mapper.DayilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Dayily ShowTodayData(){return dayilyMapper.ShowTodayData();};
    public boolean UpdateUp(Integer up){return dayilyMapper.UpdateUp(up);};
    public boolean UpdateSleep(Integer sleep){return dayilyMapper.UpdateSleep(sleep);};

    public boolean UpdateEnalish( Integer English){return dayilyMapper.UpdateEnalish(English);};
    public boolean UpdateMovement( Integer movement){return dayilyMapper.UpdateMovement(movement);};
    public boolean UpdateGame( Integer game){return dayilyMapper.UpdateGame(game);};
    public boolean UpdateLove( Integer love){return dayilyMapper.UpdateLove(love);};
    public boolean UpdateWork( Integer work){return dayilyMapper.UpdateWork(work);};
    public boolean UpdateSmoke( Integer smoke){return dayilyMapper.UpdateSmoke(smoke);};
    public boolean UpdateDaima( Integer daima){return dayilyMapper.UpdateDaima(daima);};
    public boolean UpdateMoney( Integer money){return dayilyMapper.UpdateMoney(money);};
    public boolean UpdateDiary( String diary){return dayilyMapper.UpdateDiary(diary);};




    public boolean Update(Dayily dayily)
    {
        return dayilyMapper.Update(dayily);
    }
    public Map<String,BigDecimal> sum(){return dayilyMapper.sum();};

    public List<Dayily> ShowAllDiary(){return dayilyMapper.ShowAllDiary();};

}

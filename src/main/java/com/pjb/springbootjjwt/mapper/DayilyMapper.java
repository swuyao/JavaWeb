package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.Dayily;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yc
 * @date 2018-07-08 20:44
 */
public interface DayilyMapper {
  Dayily ShowTodayData();
  boolean UpdateUp(@Param("up") Integer up);
  boolean UpdateSleep(@Param("sleep") Integer sleep);
  boolean UpdateEnalish(@Param("English") Integer English);
  boolean UpdateMovement(@Param("movement") Integer movement);
  boolean UpdateGame(@Param("game") Integer game);
  boolean UpdateLove(@Param("love") Integer love);
  boolean UpdateWork(@Param("work") Integer work);
  boolean UpdateSmoke(@Param("smoke") Integer smoke);
  boolean UpdateDaima(@Param("daima") Integer daima);
  boolean UpdateMoney(@Param("money") Integer money);
  boolean UpdateDiary(@Param("diary") String diary);

  List sum();

  Dayily ShowAllDiary();




}

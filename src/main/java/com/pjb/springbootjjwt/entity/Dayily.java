package com.pjb.springbootjjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author yc
 * @date 2018-07-08 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dayily {
    int day;
    int up;
    int sleep;
    int English;
    int movement;
    int game;
    int love;
    int work;
    int smoke;
    int daima;
    int money;
    Date todaydate;
    String diary;

}

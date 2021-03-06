package com.pjb.springbootjjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yc
 * @date 2018-07-08 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String username;
    String password;
    String token;
}

package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @author yc
 * @date 2018-07-08 20:44
 */
public interface UserMapper {

    boolean adduser(User user);
    User findByUsername(@Param("username") String username);
    boolean updatetoken (@Param("id") Integer id,@Param("token") String token);
    String selectIdBytoken(@Param("token") String token);
    String selectNameBytoken(@Param("token") String token);

}

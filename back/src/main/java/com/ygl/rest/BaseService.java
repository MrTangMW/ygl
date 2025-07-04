package com.ygl.rest;

import com.ygl.entity.UserInfoPo;
import com.ygl.service.read.UserInfoReadService;
import com.ygl.service.write.UserInfoWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: baseService
 * @Description: 基础类
 * @Author:tangmw
 * @Date 2024-07-19
 * @Version 1.0
 */
@RestController
@RequestMapping("/baseService")
public class BaseService {
    @Autowired
    private   DataSource dataSource;

    @Resource
    private UserInfoWriteService userInfoWriteService;

    @Resource
    private UserInfoReadService userInfoReadService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @PostMapping("login")
    public void login(){
        System.out.println("登录");
    }

    @PostMapping("regist")
    public  void regist(@RequestBody Object req){
        System.out.println("注册");
        System.out.println(req);
        UserInfoPo userInfoPo=new UserInfoPo();
    }

    @PostMapping("testSql")
    public UserInfoPo testSql() {
        String sql = "SELECT * FROM user_info WHERE user_id = ?";
        UserInfoPo userInfoPo = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1); // 设置参数
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 假设用户表中有 id, name, age 字段
                userInfoPo = new UserInfoPo();
                userInfoPo.setUserId(resultSet.getString("user_id"));
                userInfoPo.setUserSex(resultSet.getString("user_sex"));
                userInfoPo.setUserName(resultSet.getString("user_name"));
                userInfoPo.setUserHeadUrl(resultSet.getString("user_head_url"));
                userInfoPo.setUserIntro(resultSet.getString("user_intro"));
                userInfoPo.setUserBirth(resultSet.getDate("user_birth"));
                userInfoPo.setUseFlag(resultSet.getInt("use_flag"));
                userInfoPo.setCreateTime(resultSet.getDate("create_time"));
                userInfoPo.setUpdateTime(resultSet.getDate("update_time"));
                userInfoPo.setOpterId(resultSet.getString("opter_id"));
                userInfoPo.setOpterName(resultSet.getString("opter_name"));
                userInfoPo.setThirdId(resultSet.getString("third_id"));
               // System.out.println(userInfoPo.toMap());
            }
        } catch (SQLException e) {
            // 处理异常
            e.printStackTrace();
        }
        return userInfoPo;
    }

    @PostMapping("getUserInfoPo")
    public UserInfoPo getUserInfoPo(@RequestBody Map req) {
        System.out.println(req);
        return   userInfoReadService.queryById("1");
    }

    @PostMapping("getRedisVaule")
    public String getRedisVaule(@RequestBody Map req) {
         return stringRedisTemplate.opsForValue().get(req.get("key"));
    }

    @PostMapping("setRedisVaule")
    public void setRedisVaule(@RequestBody Map req) {
         stringRedisTemplate.opsForValue().set(req.get("key").toString(), req.get("value").toString(),5, TimeUnit.SECONDS);
    }
}

package com.ygl.mapper.read;

import com.ygl.entity.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 用户信息表(UserInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 16:22:58
*/
@Mapper
public interface UserInfoReadMapper   {

/**
* 通过ID查询单条数据
*
* @param userId 主键
* @return 实例对象
*/
UserInfoPo queryById(String userId);

/**
* 通过实体作为筛选条件查询
*
* @param userInfo 实例对象
* @return 对象列表
*/
List<UserInfoPo> queryAll(UserInfoPo userInfo);

}

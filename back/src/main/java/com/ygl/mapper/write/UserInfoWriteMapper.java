package com.ygl.mapper.write;

import com.ygl.entity.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 用户信息表(UserInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 16:23:04
*/
@Mapper
public interface UserInfoWriteMapper {
/**
* 新增数据
*
* @param userInfo 实例对象
* @return 影响行数
*/
int insert(UserInfoPo userInfo);

/**
* 修改数据
*
* @param userInfo 实例对象
* @return 影响行数
*/
int update(UserInfoPo userInfo);

/**
* 通过主键删除数据
*
* @param userId 主键
* @return 影响行数
*/
int deleteById(String userId);

}

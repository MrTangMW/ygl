package com.ygl.service.read.impl;

import com.ygl.entity.UserInfoPo;
import com.ygl.mapper.read.UserInfoReadMapper;
import com.ygl.service.read.UserInfoReadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* 用户信息表(UserInfo)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:27:35
*/
@Service
@Transactional(readOnly = true)
public class UserInfoReadServiceImpl implements UserInfoReadService {
@Resource
private UserInfoReadMapper userInfoReadMapper;

/**
* 通过ID查询单条数据
*
* @param userId 主键
* @return 实例对象
*/
@Override
public UserInfoPo queryById(String userId) {
return this.userInfoReadMapper.queryById(userId);
}

}

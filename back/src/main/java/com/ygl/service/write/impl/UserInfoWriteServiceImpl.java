package com.ygl.service.write.impl;

import com.ygl.entity.UserInfoPo;
import com.ygl.mapper.write.UserInfoWriteMapper;
import com.ygl.service.write.UserInfoWriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* 用户信息表(UserInfo)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:27:36
*/
@Service
@Transactional
public class UserInfoWriteServiceImpl implements UserInfoWriteService {
@Resource
private UserInfoWriteMapper userInfoWriteMapper;
/**
* 新增数据
*
* @param userInfo 实例对象
* @return 实例对象
*/
@Override
public UserInfoPo insert(UserInfoPo userInfo) {
this.userInfoWriteMapper.insert(userInfo);
return userInfo;
}

/**
* 修改数据
*
* @param userInfo 实例对象
* @return 实例对象
*/
@Override
public UserInfoPo update(UserInfoPo userInfo) {
return null;
}

/**
* 通过主键删除数据
*
* @param userId 主键
* @return 是否成功
*/
@Override
public boolean deleteById(String userId) {
return this.userInfoWriteMapper.deleteById(userId) > 0;
}
}

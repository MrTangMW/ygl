package com.ygl.service.write;

import com.ygl.entity.UserInfoPo;

/**
* 用户信息表(UserInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:36
*/
public interface UserInfoWriteService {
/**
* 新增数据
*
* @param userInfo 实例对象
* @return 实例对象
*/
UserInfoPo insert(UserInfoPo userInfo);

/**
* 修改数据
*
* @param userInfo 实例对象
* @return 实例对象
*/
UserInfoPo update(UserInfoPo userInfo);

/**
* 通过主键删除数据
*
* @param userId 主键
* @return 是否成功
*/
boolean deleteById(String userId);

}

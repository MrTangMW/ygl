package com.ygl.service.read;

import com.ygl.entity.UserInfoPo;

/**
* 用户信息表(UserInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:35
*/
public interface UserInfoReadService {

/**
* 通过ID查询单条数据
*
* @param userId 主键
* @return 实例对象
*/
UserInfoPo queryById(String userId);


}

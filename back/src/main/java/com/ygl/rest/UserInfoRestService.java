package com.ygl.rest;

import com.ygl.entity.UserInfoPo;
import com.ygl.service.read.UserInfoReadService;
import com.ygl.service.write.UserInfoWriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
* 用户信息表(UserInfo)表控制层
*
* @author makejava
* @since 2024-07-19 16:23:09
*/
@RestController
@RequestMapping("/userInfo")
@Valid
public class UserInfoRestService{
/**
* 服务对象
*/
@Resource
private UserInfoReadService userInfoReadService;
@Resource
private UserInfoWriteService userInfoWriteService;
/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@PostMapping("selectOne")
public UserInfoPo selectOne(String id) {
return this.userInfoReadService.queryById(id);
}

}

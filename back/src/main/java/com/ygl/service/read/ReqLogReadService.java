package com.ygl.service.read;

import com.ygl.entity.ReqLogPo;
import java.util.List;

/**
* 日志表(ReqLog)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:18
*/
public interface ReqLogReadService {

/**
* 通过ID查询单条数据
*
* @param reqLogId 主键
* @return 实例对象
*/
ReqLogPo queryById(Integer reqLogId);


}
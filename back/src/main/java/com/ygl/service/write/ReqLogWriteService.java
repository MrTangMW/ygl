package com.ygl.service.write;

import com.ygl.entity.ReqLogPo;
import java.util.List;

/**
* 日志表(ReqLog)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:18
*/
public interface ReqLogWriteService {
/**
* 新增数据
*
* @param reqLog 实例对象
* @return 实例对象
*/
ReqLogPo insert(ReqLogPo reqLog);

/**
* 修改数据
*
* @param reqLog 实例对象
* @return 实例对象
*/
ReqLogPo update(ReqLogPo reqLog);

/**
* 通过主键删除数据
*
* @param reqLogId 主键
* @return 是否成功
*/
boolean deleteById(Integer reqLogId);

}
package com.ygl.service.write.impl;

import com.ygl.entity.ReqLogPo;
import com.ygl.mapper.write.ReqLogWriteMapper;
import com.ygl.service.write.ReqLogWriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* 日志表(ReqLog)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:27:18
*/
@Service
@Transactional
public class ReqLogWriteServiceImpl implements ReqLogWriteService {

@Resource
private ReqLogWriteMapper reqLogWriteMapper;
/**
* 新增数据
*
* @param reqLog 实例对象
* @return 实例对象
*/
@Override
public ReqLogPo insert(ReqLogPo reqLog) {
this.reqLogWriteMapper.insert(reqLog);
return reqLog;
}

/**
* 修改数据
*
* @param reqLog 实例对象
* @return 实例对象
*/
@Override
public ReqLogPo update(ReqLogPo reqLog) {
return null;
}

/**
* 通过主键删除数据
*
* @param reqLogId 主键
* @return 是否成功
*/
@Override
public boolean deleteById(Integer reqLogId) {
return this.reqLogWriteMapper.deleteById(reqLogId) > 0;
}
}

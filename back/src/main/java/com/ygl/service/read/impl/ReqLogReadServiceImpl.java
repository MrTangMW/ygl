package com.ygl.service.read.impl;

import com.ygl.entity.ReqLogPo;
import com.ygl.mapper.read.ReqLogReadMapper;
import com.ygl.service.read.ReqLogReadService;
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
@Transactional(readOnly = true)
public class ReqLogReadServiceImpl implements ReqLogReadService {
@Resource
private ReqLogReadMapper reqLogReadMapper;

/**
* 通过ID查询单条数据
*
* @param reqLogId 主键
* @return 实例对象
*/
@Override
public ReqLogPo queryById(Integer reqLogId) {
return this.reqLogReadMapper.queryById(reqLogId);
}

}

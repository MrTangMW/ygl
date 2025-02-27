package com.ygl.mapper.read;

import com.ygl.entity.ReqLogPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 日志表(ReqLog)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:27:17
*/
@Mapper
public interface ReqLogReadMapper {

/**
* 通过ID查询单条数据
*
* @param reqLogId 主键
* @return 实例对象
*/
ReqLogPo queryById(Integer reqLogId);

/**
* 通过实体作为筛选条件查询
*
* @param reqLog 实例对象
* @return 对象列表
*/
List<ReqLogPo> queryAll(ReqLogPo reqLog);

}

package com.ygl.mapper.write;

import com.ygl.entity.ReqLogPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* 日志表(ReqLog)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:27:17
*/
@Mapper
public interface ReqLogWriteMapper {
/**
* 新增数据
*
* @param reqLog 实例对象
* @return 影响行数
*/
int insert(ReqLogPo reqLog);

/**
* 修改数据
*
* @param reqLog 实例对象
* @return 影响行数
*/
int update(ReqLogPo reqLog);

/**
* 通过主键删除数据
*
* @param reqLogId 主键
* @return 影响行数
*/
int deleteById(Integer reqLogId);

}

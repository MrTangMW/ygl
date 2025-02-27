package com.ygl.mapper.read;

import com.ygl.entity.CommentInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* (CommentInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:27:02
*/
@Mapper
public interface CommentInfoReadMapper  {

/**
* 通过ID查询单条数据
*
* @param commentId 主键
* @return 实例对象
*/
CommentInfoPo queryById(String commentId);

/**
* 通过实体作为筛选条件查询
*
* @param commentInfo 实例对象
* @return 对象列表
*/
List<CommentInfoPo> queryAll(CommentInfoPo commentInfo);

}

package com.ygl.mapper.write;

import com.ygl.entity.CommentInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* (CommentInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:27:03
*/
@Mapper
public interface CommentInfoWriteMapper {
/**
* 新增数据
*
* @param commentInfo 实例对象
* @return 影响行数
*/
int insert(CommentInfoPo commentInfo);

/**
* 修改数据
*
* @param commentInfo 实例对象
* @return 影响行数
*/
int update(CommentInfoPo commentInfo);

/**
* 通过主键删除数据
*
* @param commentId 主键
* @return 影响行数
*/
int deleteById(String commentId);

}

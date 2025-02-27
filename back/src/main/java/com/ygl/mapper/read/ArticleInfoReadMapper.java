package com.ygl.mapper.read;

import com.ygl.entity.ArticleInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* (ArticleInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:26:26
*/
@Mapper
public interface ArticleInfoReadMapper {

/**
* 通过ID查询单条数据
*
* @param articleId 主键
* @return 实例对象
*/
ArticleInfoPo queryById(String articleId);

/**
* 通过实体作为筛选条件查询
*
* @param articleInfo 实例对象
* @return 对象列表
*/
List<ArticleInfoPo> queryAll(ArticleInfoPo articleInfo);

}

package com.ygl.mapper.write;

import com.ygl.entity.ArticleInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* (ArticleInfo)表数据库访问层
*
* @author makejava
* @since 2024-07-19 17:26:27
*/
@Mapper
public interface ArticleInfoWriteMapper {
/**
* 新增数据
*
* @param articleInfo 实例对象
* @return 影响行数
*/
int insert(ArticleInfoPo articleInfo);

/**
* 修改数据
*
* @param articleInfo 实例对象
* @return 影响行数
*/
int update(ArticleInfoPo articleInfo);

/**
* 通过主键删除数据
*
* @param articleId 主键
* @return 影响行数
*/
int deleteById(String articleId);

}

package com.ygl.service.write;

import com.ygl.entity.ArticleInfoPo;
import java.util.List;

/**
* (ArticleInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:26:30
*/
public interface ArticleInfoWriteService {
/**
* 新增数据
*
* @param articleInfo 实例对象
* @return 实例对象
*/
ArticleInfoPo insert(ArticleInfoPo articleInfo);

/**
* 修改数据
*
* @param articleInfo 实例对象
* @return 实例对象
*/
ArticleInfoPo update(ArticleInfoPo articleInfo);

/**
* 通过主键删除数据
*
* @param articleId 主键
* @return 是否成功
*/
boolean deleteById(String articleId);

}
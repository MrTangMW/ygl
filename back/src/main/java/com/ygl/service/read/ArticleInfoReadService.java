package com.ygl.service.read;

import com.ygl.entity.ArticleInfoPo;
import java.util.List;

/**
* (ArticleInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:26:29
*/
public interface ArticleInfoReadService {

/**
* 通过ID查询单条数据
*
* @param articleId 主键
* @return 实例对象
*/
ArticleInfoPo queryById(String articleId);


}
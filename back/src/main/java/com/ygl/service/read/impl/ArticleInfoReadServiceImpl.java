package com.ygl.service.read.impl;

import com.ygl.entity.ArticleInfoPo;
import com.ygl.mapper.read.ArticleInfoReadMapper;
import com.ygl.service.read.ArticleInfoReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* (ArticleInfo)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:26:30
*/
@Service
@Transactional(readOnly = true)
public class ArticleInfoReadServiceImpl implements ArticleInfoReadService {
@Resource
private ArticleInfoReadMapper articleInfoReadMapper;

/**
* 通过ID查询单条数据
*
* @param articleId 主键
* @return 实例对象
*/
@Override
public ArticleInfoPo queryById(String articleId) {
return this.articleInfoReadMapper.queryById(articleId);
}

}

package com.ygl.service.write.impl;

import com.ygl.entity.ArticleInfoPo;
import com.ygl.mapper.write.ArticleInfoWriteMapper;
import com.ygl.service.write.ArticleInfoWriteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* (ArticleInfo)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:26:31
*/
@Service
@Transactional
public class ArticleInfoWriteServiceImpl implements ArticleInfoWriteService {
@Resource
private ArticleInfoWriteMapper articleInfoWriteMapper;
/**
* 新增数据
*
* @param articleInfo 实例对象
* @return 实例对象
*/
@Override
public ArticleInfoPo insert(ArticleInfoPo articleInfo) {
this.articleInfoWriteMapper.insert(articleInfo);
return articleInfo;
}

/**
* 修改数据
*
* @param articleInfo 实例对象
* @return 实例对象
*/
@Override
public ArticleInfoPo update(ArticleInfoPo articleInfo) {
return null;
}

/**
* 通过主键删除数据
*
* @param articleId 主键
* @return 是否成功
*/
@Override
public boolean deleteById(String articleId) {
return this.articleInfoWriteMapper.deleteById(articleId) > 0;
}
}

package com.ygl.service.read.impl;

import com.ygl.entity.CommentInfoPo;
import com.ygl.mapper.read.CommentInfoReadMapper;
import com.ygl.service.read.CommentInfoReadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* (CommentInfo)表服务实现类
*
* @author makejava
* @since 2024-07-19 17:27:03
*/
@Service
@Transactional(readOnly = true)
public class CommentInfoReadServiceImpl implements CommentInfoReadService {
@Resource
private CommentInfoReadMapper commentInfoReadMapper;

/**
* 通过ID查询单条数据
*
* @param commentId 主键
* @return 实例对象
*/
@Override
public CommentInfoPo queryById(String commentId) {
return this.commentInfoReadMapper.queryById(commentId);
}

}

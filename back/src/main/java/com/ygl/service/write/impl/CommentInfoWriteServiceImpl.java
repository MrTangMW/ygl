package com.ygl.service.write.impl;

import com.ygl.entity.CommentInfoPo;
import com.ygl.mapper.write.CommentInfoWriteMapper;
import com.ygl.service.write.CommentInfoWriteService;
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
@Transactional
public class CommentInfoWriteServiceImpl implements CommentInfoWriteService {
@Resource
private CommentInfoWriteMapper commentInfoWriteMapper;
/**
* 新增数据
*
* @param commentInfo 实例对象
* @return 实例对象
*/
@Override
public CommentInfoPo insert(CommentInfoPo commentInfo) {
this.commentInfoWriteMapper.insert(commentInfo);
return commentInfo;
}

/**
* 修改数据
*
* @param commentInfo 实例对象
* @return 实例对象
*/
@Override
public CommentInfoPo update(CommentInfoPo commentInfo) {
return null;
}

/**
* 通过主键删除数据
*
* @param commentId 主键
* @return 是否成功
*/
@Override
public boolean deleteById(String commentId) {
return this.commentInfoWriteMapper.deleteById(commentId) > 0;
}
}

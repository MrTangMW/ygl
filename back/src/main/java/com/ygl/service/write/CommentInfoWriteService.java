package com.ygl.service.write;

import com.ygl.entity.CommentInfoPo;
import java.util.List;

/**
* (CommentInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:03
*/
public interface CommentInfoWriteService {
/**
* 新增数据
*
* @param commentInfo 实例对象
* @return 实例对象
*/
CommentInfoPo insert(CommentInfoPo commentInfo);

/**
* 修改数据
*
* @param commentInfo 实例对象
* @return 实例对象
*/
CommentInfoPo update(CommentInfoPo commentInfo);

/**
* 通过主键删除数据
*
* @param commentId 主键
* @return 是否成功
*/
boolean deleteById(String commentId);

}
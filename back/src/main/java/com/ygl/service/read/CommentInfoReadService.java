package com.ygl.service.read;

import com.ygl.entity.CommentInfoPo;
import java.util.List;

/**
* (CommentInfo)表服务接口
*
* @author makejava
* @since 2024-07-19 17:27:03
*/
public interface CommentInfoReadService {

/**
* 通过ID查询单条数据
*
* @param commentId 主键
* @return 实例对象
*/
CommentInfoPo queryById(String commentId);


}
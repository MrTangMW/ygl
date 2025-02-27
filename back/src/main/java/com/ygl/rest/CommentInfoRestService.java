package com.ygl.rest;

import com.ygl.entity.CommentInfoPo;
import com.ygl.service.read.CommentInfoReadService;
import com.ygl.service.write.CommentInfoWriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
* (CommentInfo)表控制层
*
* @author makejava
* @since 2024-07-19 17:27:03
*/
@RestController
@RequestMapping("/commentInfo")

@Valid
public class CommentInfoRestService {
/**
* 服务对象
*/
@Resource
private CommentInfoReadService commentInfoReadService;
@Resource
private CommentInfoWriteService commentInfoWriteService;
/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@PostMapping("selectOne")
public CommentInfoPo selectOne(String id) {
return this.commentInfoReadService.queryById(id);
}

}

package com.ygl.rest;

import com.ygl.entity.ArticleInfoPo;
import com.ygl.service.read.ArticleInfoReadService;
import com.ygl.service.write.ArticleInfoWriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
* (ArticleInfo)表控制层
*
* @author makejava
* @since 2024-07-19 17:26:34
*/
@RestController
@RequestMapping("/articleInfo")

@Valid
public class ArticleInfoRestService  {
/**
* 服务对象
*/
@Resource
private ArticleInfoReadService articleInfoReadService;
@Resource
private ArticleInfoWriteService articleInfoWriteService;
/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@PostMapping("selectOne")
public ArticleInfoPo selectOne(String id) {
return this.articleInfoReadService.queryById(id);
}

}

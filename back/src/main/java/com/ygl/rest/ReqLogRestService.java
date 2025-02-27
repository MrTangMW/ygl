package com.ygl.rest;

import com.ygl.entity.ReqLogPo;
import com.ygl.service.read.ReqLogReadService;
import com.ygl.service.write.ReqLogWriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
* 日志表(ReqLog)表控制层
*
* @author makejava
* @since 2024-07-19 17:27:18
*/
@RestController
@RequestMapping("/reqLog")
@Valid
public class ReqLogRestService {
/**
* 服务对象
*/
@Resource
private ReqLogReadService reqLogReadService;
@Resource
private ReqLogWriteService reqLogWriteService;
/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@PostMapping("selectOne")
public ReqLogPo selectOne(Integer id) {
return this.reqLogReadService.queryById(id);
}

}

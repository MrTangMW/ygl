package com.ygl.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志表(ReqLog)实体类
 *
 * @author makejava
 * @since 2024-07-19 17:27:16
 */
public class ReqLogPo implements Serializable {
    private static final long serialVersionUID = -20421352515379043L;
    //请求id
    private Integer reqLogId;
    //输入
    private String input;
    //输出
    private String output;
    //创建时间
    private Date createTime;
    //请求状态
    private String reqStas;
    //请求时间
    private String reqTime;


    public Integer getReqLogId() {
        return reqLogId;
    }

    public void setReqLogId(Integer reqLogId) {
        this.reqLogId = reqLogId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReqStas() {
        return reqStas;
    }

    public void setReqStas(String reqStas) {
        this.reqStas = reqStas;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public Map toMap() {
        Map map = new HashMap();
        map.put("reqLogId", reqLogId);
        map.put("input", input);
        map.put("output", output);
        map.put("createTime", createTime);
        map.put("reqStas", reqStas);
        map.put("reqTime", reqTime);
        return map;
    }

    @Override
    public String toString() {
        return "ReqLog{" +
                ",reqLogId ='" + reqLogId + '\'' +
                ",input ='" + input + '\'' +
                ",output ='" + output + '\'' +
                ",createTime ='" + createTime + '\'' +
                ",reqStas ='" + reqStas + '\'' +
                ",reqTime ='" + reqTime + '\'' +
                '}';
    }

}

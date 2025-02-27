package com.ygl.entity;


import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
* 用户信息表(UserInfo)实体类
*
* @author makejava
* @since 2024-07-19 16:22:58
*/
public class UserInfoPo implements Serializable {
private static final long serialVersionUID = 288628604715435691L;
    //用户ID
private String userId;
    //用户名称
private String userName;
    //性别
private String userSex;
    //头像地址
private String userHeadUrl;
    //简介
private String userIntro;
    //出生日期
private Date userBirth;
    //有效标志
private Integer useFlag;
    //创建时间
private Date createTime;
    //更新时间
private Date updateTime;
    //操作人
private String opterName;
    //操作人id
private String opterId;
    //第三方id
private String thirdId;


public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getUserSex() {
return userSex;
}

public void setUserSex(String userSex) {
this.userSex = userSex;
}

public String getUserHeadUrl() {
return userHeadUrl;
}

public void setUserHeadUrl(String userHeadUrl) {
this.userHeadUrl = userHeadUrl;
}

public String getUserIntro() {
return userIntro;
}

public void setUserIntro(String userIntro) {
this.userIntro = userIntro;
}

public Date getUserBirth() {
return userBirth;
}

public void setUserBirth(Date userBirth) {
this.userBirth = userBirth;
}

public Integer getUseFlag() {
return useFlag;
}

public void setUseFlag(Integer useFlag) {
this.useFlag = useFlag;
}

public Date getCreateTime() {
return createTime;
}

public void setCreateTime(Date createTime) {
this.createTime = createTime;
}

public Date getUpdateTime() {
return updateTime;
}

public void setUpdateTime(Date updateTime) {
this.updateTime = updateTime;
}

public String getOpterName() {
return opterName;
}

public void setOpterName(String opterName) {
this.opterName = opterName;
}

public String getOpterId() {
return opterId;
}

public void setOpterId(String opterId) {
this.opterId = opterId;
}

public String getThirdId() {
return thirdId;
}

public void setThirdId(String thirdId) {
this.thirdId = thirdId;
}
        public Map toMap(){
    Map map = new HashMap();
        map.put("userId",userId);
        map.put("userName",userName);
        map.put("userSex",userSex);
        map.put("userHeadUrl",userHeadUrl);
        map.put("userIntro",userIntro);
        map.put("userBirth",userBirth);
        map.put("useFlag",useFlag);
        map.put("createTime",createTime);
        map.put("updateTime",updateTime);
        map.put("opterName",opterName);
        map.put("opterId",opterId);
        map.put("thirdId",thirdId);
        return map;
    }
        @Override
    public String toString() {
    return "UserInfo{" +
               ",userId ='" + userId + '\'' +
               ",userName ='" + userName + '\'' +
               ",userSex ='" + userSex + '\'' +
               ",userHeadUrl ='" + userHeadUrl + '\'' +
               ",userIntro ='" + userIntro + '\'' +
               ",userBirth ='" + userBirth + '\'' +
               ",useFlag ='" + useFlag + '\'' +
               ",createTime ='" + createTime + '\'' +
               ",updateTime ='" + updateTime + '\'' +
               ",opterName ='" + opterName + '\'' +
               ",opterId ='" + opterId + '\'' +
               ",thirdId ='" + thirdId + '\'' +
            '}';
    }

}

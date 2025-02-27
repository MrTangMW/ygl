package com.ygl.entity;


import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
* (ArticleInfo)实体类
*
* @author makejava
* @since 2024-07-19 17:26:23
*/
public class ArticleInfoPo implements Serializable {
private static final long serialVersionUID = 851582828762497147L;
    //文章id
private String articleId;
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
    //文章标题
private String articleTitle;
    //文章附件
private String articleFj;
    //文章内容
private String articleContent;


public String getArticleId() {
return articleId;
}

public void setArticleId(String articleId) {
this.articleId = articleId;
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

public String getArticleTitle() {
return articleTitle;
}

public void setArticleTitle(String articleTitle) {
this.articleTitle = articleTitle;
}

public String getArticleFj() {
return articleFj;
}

public void setArticleFj(String articleFj) {
this.articleFj = articleFj;
}

public String getArticleContent() {
return articleContent;
}

public void setArticleContent(String articleContent) {
this.articleContent = articleContent;
}
        public Map toMap(){
    Map map = new HashMap();
        map.put("articleId",articleId);
        map.put("useFlag",useFlag);
        map.put("createTime",createTime);
        map.put("updateTime",updateTime);
        map.put("opterName",opterName);
        map.put("opterId",opterId);
        map.put("articleTitle",articleTitle);
        map.put("articleFj",articleFj);
        map.put("articleContent",articleContent);
        return map;
    }
        @Override
    public String toString() {
    return "ArticleInfo{" +
               ",articleId ='" + articleId + '\'' +
               ",useFlag ='" + useFlag + '\'' +
               ",createTime ='" + createTime + '\'' +
               ",updateTime ='" + updateTime + '\'' +
               ",opterName ='" + opterName + '\'' +
               ",opterId ='" + opterId + '\'' +
               ",articleTitle ='" + articleTitle + '\'' +
               ",articleFj ='" + articleFj + '\'' +
               ",articleContent ='" + articleContent + '\'' +
            '}';
    }

}

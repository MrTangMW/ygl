package com.ygl.entity;



import java.util.Date;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
* (CommentInfo)实体类
*
* @author makejava
* @since 2024-07-19 17:27:01
*/
public class CommentInfoPo implements Serializable {
private static final long serialVersionUID = 866163667928736542L;
    //评论id
private String commentId;
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
    //评论内容
private String commentContent;
    //评论附件
private String commentFj;
    //评论序号
private Integer commentNum;


public String getCommentId() {
return commentId;
}

public void setCommentId(String commentId) {
this.commentId = commentId;
}

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

public String getCommentContent() {
return commentContent;
}

public void setCommentContent(String commentContent) {
this.commentContent = commentContent;
}

public String getCommentFj() {
return commentFj;
}

public void setCommentFj(String commentFj) {
this.commentFj = commentFj;
}

public Integer getCommentNum() {
return commentNum;
}

public void setCommentNum(Integer commentNum) {
this.commentNum = commentNum;
}
        public Map toMap(){
    Map map = new HashMap();
        map.put("commentId",commentId);
        map.put("articleId",articleId);
        map.put("useFlag",useFlag);
        map.put("createTime",createTime);
        map.put("updateTime",updateTime);
        map.put("opterName",opterName);
        map.put("opterId",opterId);
        map.put("commentContent",commentContent);
        map.put("commentFj",commentFj);
        map.put("commentNum",commentNum);
        return map;
    }
        @Override
    public String toString() {
    return "CommentInfo{" +
               ",commentId ='" + commentId + '\'' +
               ",articleId ='" + articleId + '\'' +
               ",useFlag ='" + useFlag + '\'' +
               ",createTime ='" + createTime + '\'' +
               ",updateTime ='" + updateTime + '\'' +
               ",opterName ='" + opterName + '\'' +
               ",opterId ='" + opterId + '\'' +
               ",commentContent ='" + commentContent + '\'' +
               ",commentFj ='" + commentFj + '\'' +
               ",commentNum ='" + commentNum + '\'' +
            '}';
    }

}

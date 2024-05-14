package re.kaguya._04mybatis.pojo.vo;


import re.kaguya._04mybatis.pojo.entity.Comment;

import java.util.List;

public class WeiboCommentVo1 {
    private Long id;
    private String content;
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "WeiboCommentVo1{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}

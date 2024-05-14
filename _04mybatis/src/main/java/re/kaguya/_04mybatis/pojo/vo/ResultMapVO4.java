package re.kaguya._04mybatis.pojo.vo;

import java.util.List;

public class ResultMapVO4 {
    private Long id;
    private String content;
    private List<CommentVo3> commentList;

    @Override
    public String toString() {
        return "ResulMapVO4{" +
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

    public List<CommentVo3> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentVo3> commentList) {
        this.commentList = commentList;
    }
}

package cn.tedu._04mybatis.pojo.vo;

public class CommentVo1 {
    private String content;
    private Long userId;
    private Long weiboId;

    @Override
    public String toString() {
        return "CommentVo1{" +
                "content='" + content + '\'' +
                ", userId=" + userId +
                ", weiboId=" + weiboId +
                '}';
    }
}

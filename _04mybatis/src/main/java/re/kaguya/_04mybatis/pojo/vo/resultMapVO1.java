package re.kaguya._04mybatis.pojo.vo;

public class resultMapVO1 {
    private Long id;
    private String content;
    private Long userId;
    @Override
    public String toString() {
        return "resultMapVO1{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

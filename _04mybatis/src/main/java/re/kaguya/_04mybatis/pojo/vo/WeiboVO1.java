package re.kaguya._04mybatis.pojo.vo;

import java.sql.Date;

public class WeiboVO1 {
    private String content;

    private Date created;

    @Override
    public String toString() {
        return "WeiboVO1{" +
                "content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}

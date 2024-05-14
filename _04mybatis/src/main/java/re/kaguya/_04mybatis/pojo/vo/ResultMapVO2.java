package re.kaguya._04mybatis.pojo.vo;

import re.kaguya._04mybatis.pojo.entity.Weibo;

import java.util.List;

public class ResultMapVO2 {
    private long id;
    private String nickname;
    private List<Weibo> weiboList;

    @Override
    public String toString() {
        return "ResultMapVO2{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", weiboList=" + weiboList +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Weibo> getWeiboList() {
        return weiboList;
    }

    public void setWeiboList(List<Weibo> weiboList) {
        this.weiboList = weiboList;
    }
}

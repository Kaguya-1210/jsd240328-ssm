package re.kaguya._05weibo.mapper;

import re.kaguya._05weibo.pojo.entity.Weibo;
import re.kaguya._05weibo.pojo.vo.WeiboDetailVO;
import re.kaguya._05weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeiboMapper {
    int insert(Weibo weibo);

    List<WeiboIndexVO> select();

    WeiboDetailVO selectWeibo(Integer id);
}

package re.kaguya._weibo_kaguya.mapper;

import re.kaguya._weibo_kaguya.pojo.entity.Weibo;
import re.kaguya._weibo_kaguya.pojo.vo.WeiboDetailVO;
import re.kaguya._weibo_kaguya.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeiboMapper {
    void insert(Weibo weibo);

    List<WeiboIndexVO> selectIndex();

    WeiboDetailVO selectById(Integer id);
}

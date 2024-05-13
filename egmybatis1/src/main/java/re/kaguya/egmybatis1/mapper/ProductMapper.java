package re.kaguya.egmybatis1.mapper;

import org.apache.ibatis.annotations.Mapper;
import re.kaguya.egmybatis1.pojo.entity.Product;
import re.kaguya.egmybatis1.pojo.vo.ProductVo;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(Product product);

    List<ProductVo> selectProduct(Long uid);

    void deleteProduct(Long uid);

}

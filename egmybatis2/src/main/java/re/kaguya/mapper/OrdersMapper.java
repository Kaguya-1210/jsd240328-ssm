package re.kaguya.mapper;

import org.apache.ibatis.annotations.Mapper;
import re.kaguya.pojo.entity.Orders;

@Mapper
public interface OrdersMapper {
    void insertOrders(Orders order);

    void updateOrders(Orders order);
}

package re.kaguya.mapper;


import org.apache.ibatis.annotations.Mapper;
import re.kaguya.pojo.entity.Customers;
import re.kaguya.pojo.vo.CustomersVO1;
import re.kaguya.pojo.vo.OrderListVO;

import java.util.List;

@Mapper
public interface CustomersMapper {
    void insertCustomer(Customers customers);

    CustomersVO1 selectCustomer(String id);

    List<CustomersVO1> selectCustomerList(String id);

    List<OrderListVO> selectOrderList(String id);
}

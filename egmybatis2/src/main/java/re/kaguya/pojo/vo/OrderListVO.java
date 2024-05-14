package re.kaguya.pojo.vo;

import lombok.Data;
import re.kaguya.pojo.entity.Orders;

import java.util.List;

@Data
public class OrderListVO {
    private String custId;
    private String custName;
    private List<Orders> orderList;
}

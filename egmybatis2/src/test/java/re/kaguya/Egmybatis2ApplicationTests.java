package re.kaguya;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import re.kaguya.mapper.CustomersMapper;
import re.kaguya.mapper.OrdersMapper;
import re.kaguya.pojo.entity.Customers;
import re.kaguya.pojo.entity.Orders;

import java.util.Date;


@SpringBootTest
class Egmybatis2ApplicationTests {

    @Autowired(required = false)
    private CustomersMapper customersMapper;

    @Test
    void XxxTest(){
        Customers customers = new Customers();
        customers.setCustId("0004");
        customers.setCustTel("13811112222");
        customers.setCustName("Tony");
        customers.setCity("成都");
        customersMapper.insertCustomer(customers);
    }

    @Autowired(required = false)
    private OrdersMapper orderMapper;
    @Test

    void OrderTest() {
        //'202301020004', '0004', new Date(), 3, 4, 800.88
        Orders orders = new Orders();
        orders.setCustId("0004");
        orders.setOrderDate(new Date());
        orders.setAmt(800.88);
        orders.setOrderId("202301020004");
        orders.setProductsNum(3);
        orders.setStatus(4);
        orderMapper.insertOrders(orders);
    }

    @Test
    void setCustomers() {
        System.out.println(customersMapper.selectCustomer("0004"));
    }

    @Test
    void setCustomersList() {
        System.out.println(customersMapper.selectCustomerList("0004"));
    }

    @Test
    void setOrderList() {
        System.out.println(customersMapper.selectOrderList("0004"));
    }

    @Test
    void update() {
        Orders o = new Orders();
        o.setOrderId("1000");
        o.setStatus(1);
        o.setAmt(2);
        o.setProductsNum(999);
        o.setCustId("0004");
        o.setOrderDate(new Date());
        orderMapper.updateOrders(o);
    }
}

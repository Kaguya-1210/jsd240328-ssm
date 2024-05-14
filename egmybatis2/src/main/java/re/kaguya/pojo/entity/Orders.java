package re.kaguya.pojo.entity;

import lombok.Data;

import java.util.Date;


@Data

public class Orders {
    private String orderId;
    private String custId;
    private Date orderDate;
    private int status;
    private int productsNum;
    private double amt;
}

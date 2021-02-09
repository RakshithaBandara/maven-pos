package lk.ijse.dep.web.pos.entity;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

public interface CustomEntity2 {

    String getOrderId();

    @Value("#{target.cId}")
    String getCustomerId();

    String getCustomerName();

    Date getOrderDate();

    BigDecimal getOrderTotal();

    default void printDetails(){
        System.out.println(getOrderId() + ", " + getCustomerId() + ", " + getCustomerName() + ", " + getOrderDate() + ", " + getOrderTotal());
    }
}

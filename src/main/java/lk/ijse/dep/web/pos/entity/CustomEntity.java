package lk.ijse.dep.web.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomEntity implements SuperEntity {
    private String orderId;
    private String customerId;
    private String customerName;
    private Date orderDate;
    private BigDecimal orderTotal;
}

package lk.ijse.dep.web.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements SuperEntity {
    @Id
    private String id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
    private List<OrderDetail> orderDetails;

    public Order(String id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }
}

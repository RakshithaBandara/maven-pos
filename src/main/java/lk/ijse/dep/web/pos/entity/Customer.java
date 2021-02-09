package lk.ijse.dep.web.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
@NamedQuery(name="Customer.temp", query = "SELECT c FROM Customer c")
public class Customer implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
}

package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface OrderDAO extends JpaRepository<Order, String> {

//    @Query("SELECT o.customer.name FROM Order o WHERE o.date = :#{T(lk.ijse.dep.web.pos.util.Temp).someDate()}")
//    @Query("SELECT o.customer.name FROM Order o WHERE o.date = :#{#date}")
////    @Query("SELECT o.customer.name FROM Order o WHERE o.date = ?#{[0]}")
//    List<String> findCustomerNamesByOrderDate(@Param("date") Date orderDate);

}

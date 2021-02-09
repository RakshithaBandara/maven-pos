package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.CustomEntity;
import lk.ijse.dep.web.pos.entity.CustomEntity2;
import lk.ijse.dep.web.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.sql.Date;

public interface OrderDAO extends JpaRepository<Order, String> {

    //    @Query("SELECT o.customer.name FROM Order o WHERE o.date = :#{T(lk.ijse.dep.web.pos.util.Temp).someDate()}")
//    @Query("SELECT o.customer.name FROM Order o WHERE o.date = :#{#date}")
////    @Query("SELECT o.customer.name FROM Order o WHERE o.date = ?#{[0]}")
//    List<String> findCustomerNamesByOrderDate(@Param("date") Date orderDate);

    List<Order> findTharangaByDateBetween(Date from, Date to);

    int countOrdersByDate(Date date);

    @Query("SELECT NEW lk.ijse.dep.web.pos.entity.CustomEntity(o.id, o.customer.id, o.customer.name, o.date,  SUM(od.qty * od.unitPrice)) FROM Order o JOIN o.orderDetails od WHERE o.date = ?1 GROUP BY o.id")
    List<CustomEntity> getOrdersByDate(Date date);

    @Query("SELECT o.id as orderId, o.customer.id as cId, o.customer.name, o.date,  SUM(od.qty * od.unitPrice) FROM Order o JOIN o.orderDetails od WHERE o.date = ?1 GROUP BY o.id")
    List<CustomEntity2> getOrdersByDate2(Date date);

}

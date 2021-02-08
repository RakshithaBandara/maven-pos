package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, String> {
}

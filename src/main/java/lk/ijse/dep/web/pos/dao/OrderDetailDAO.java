package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.entity.OrderDetail;
import lk.ijse.dep.web.pos.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, OrderDetailPK> {
}

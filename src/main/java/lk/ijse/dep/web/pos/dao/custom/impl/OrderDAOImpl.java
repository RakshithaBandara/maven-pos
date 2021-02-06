package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.CrudDAOImpl;
import lk.ijse.dep.web.pos.dao.custom.OrderDAO;
import lk.ijse.dep.web.pos.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {

}

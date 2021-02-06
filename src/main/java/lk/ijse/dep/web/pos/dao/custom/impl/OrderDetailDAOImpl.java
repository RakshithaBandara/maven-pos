package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.CrudDAOImpl;
import lk.ijse.dep.web.pos.dao.custom.OrderDetailDAO;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import lk.ijse.dep.web.pos.entity.OrderDetailPK;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {

}

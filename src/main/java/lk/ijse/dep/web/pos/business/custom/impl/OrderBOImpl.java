package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.OrderBO;
import lk.ijse.dep.web.pos.business.util.OrderEntityDTOMapper;
import lk.ijse.dep.web.pos.dao.ItemDAO;
import lk.ijse.dep.web.pos.dao.OrderDAO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.entity.Item;
import lk.ijse.dep.web.pos.entity.Order;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Service
public class OrderBOImpl implements OrderBO {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private OrderEntityDTOMapper mapper;

    public OrderBOImpl() {

    }

    @Override
    public void placeOrder(OrderDTO orderDTO) throws Exception {
        Order order = mapper.getOrder(orderDTO);
        orderDAO.save(order);
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            Item item = itemDAO.findById(orderDetail.getOrderDetailPK().getItemCode()).get();
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            if (item.getQtyOnHand() < 0) {
                throw new RuntimeException("Invalid Qty.");
            }
            itemDAO.save(item);
        }
    }
}

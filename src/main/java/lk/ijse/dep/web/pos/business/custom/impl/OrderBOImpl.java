package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.OrderBO;
import lk.ijse.dep.web.pos.business.util.OrderEntityDTOMapper;
import lk.ijse.dep.web.pos.dao.custom.ItemDAO;
import lk.ijse.dep.web.pos.dao.custom.OrderDAO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.entity.Item;
import lk.ijse.dep.web.pos.entity.Order;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class OrderBOImpl implements OrderBO {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ItemDAO itemDAO;
    private EntityManager em;
    @Autowired
    private OrderEntityDTOMapper mapper;

    public OrderBOImpl() {

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        orderDAO.setEntityManager(em);
        itemDAO.setEntityManager(em);
    }

    @Override
    public void placeOrder(OrderDTO orderDTO) throws Exception {
        try {
            em.getTransaction().begin();
            Order order = mapper.getOrder(orderDTO);
            orderDAO.save(order);
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Item item = itemDAO.get(orderDetail.getOrderDetailPK().getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                if (item.getQtyOnHand() < 0){
                    throw new RuntimeException("Invalid Qty.");
                }
                itemDAO.update(item);
            }
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}

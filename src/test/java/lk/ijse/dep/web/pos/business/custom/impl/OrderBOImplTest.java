package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.BOFactory;
import lk.ijse.dep.web.pos.business.BOTypes;
import lk.ijse.dep.web.pos.business.custom.OrderBO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.dto.OrderDetailDTO;
import lk.ijse.dep.web.pos.util.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImplTest {

    @Test
    public void placeOrder() throws Exception {
        OrderBO orderBO = BOFactory.getInstance().getBO(BOTypes.ORDER);
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        orderBO.setEntityManager(em);

        List<OrderDetailDTO> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetailDTO("OD006", "I001", 2, new BigDecimal("500")));
        orderDetails.add(new OrderDetailDTO("OD006", "I002", 2, new BigDecimal("900")));
        OrderDTO order = new OrderDTO("OD006", LocalDate.now(), "C002", orderDetails);
        orderBO.placeOrder(order);

        em.close();
    }
}

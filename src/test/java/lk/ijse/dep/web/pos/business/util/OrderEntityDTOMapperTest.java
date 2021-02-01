package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.dto.OrderDetailDTO;
import lk.ijse.dep.web.pos.entity.Order;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderEntityDTOMapperTest {

    @Test
    public void getOrder() {
        OrderEntityDTOMapper mapper = Mappers.getMapper(OrderEntityDTOMapper.class);
        List<OrderDetailDTO> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetailDTO("OD001","I001",10, new BigDecimal("200")));
        orderDetails.add(new OrderDetailDTO("OD001","I0O2",10, new BigDecimal("200")));
        OrderDTO dto = new OrderDTO("OD001", LocalDate.now(), "C001", orderDetails);
        Order order = mapper.getOrder(dto);
        System.out.println(order);
        order.getOrderDetails().forEach(System.out::println);
        assertNotNull(order);
    }

    @Test
    public void getOrderDetail(){
        OrderEntityDTOMapper mapper = Mappers.getMapper(OrderEntityDTOMapper.class);
        OrderDetail orderDetail = mapper.getOrderDetail(new OrderDetailDTO("OD001", "I001", 10, new BigDecimal("200")));
        System.out.println(orderDetail);
    }
}

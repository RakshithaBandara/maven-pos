package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.dao.CustomerDAO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.dto.OrderDetailDTO;
import lk.ijse.dep.web.pos.entity.Customer;
import lk.ijse.dep.web.pos.entity.Order;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import lk.ijse.dep.web.pos.entity.OrderDetailPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Mapper(componentModel = "spring")
public abstract class OrderEntityDTOMapper {

    @Autowired
    private CustomerDAO customerDAO;

    @Mapping(source = "orderId", target = "id")
    @Mapping(source = ".", target = "date")
    @Mapping(source = ".", target = "customer")
    public abstract Order getOrder(OrderDTO dto);

    public Date toDate(OrderDTO dto){
        return Date.valueOf(dto.getOrderDate());
    }

    public Customer getCustomer(OrderDTO dto) throws Exception{
        return customerDAO.getOne(dto.getCustomerId());
    }

    @Mapping(source = ".", target = "orderDetailPK", qualifiedByName = "pk")
    public abstract OrderDetail getOrderDetail(OrderDetailDTO dto);

    @Named("pk")
    public OrderDetailPK toOrderDetailPK(OrderDetailDTO dto){
        return new OrderDetailPK(dto.getOrderId(), dto.getItemCode());
    }
}

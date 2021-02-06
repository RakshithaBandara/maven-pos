package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.AppInitializer;
import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.dto.OrderDetailDTO;
import lk.ijse.dep.web.pos.entity.Customer;
import lk.ijse.dep.web.pos.entity.Order;
import lk.ijse.dep.web.pos.entity.OrderDetail;
import lk.ijse.dep.web.pos.entity.OrderDetailPK;
import lk.ijse.dep.web.pos.util.JPAUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.persistence.EntityManager;
import java.sql.Date;

@Mapper(componentModel = "spring")
public interface OrderEntityDTOMapper {

    @Mapping(source = "orderId", target = "id")
    @Mapping(source = ".", target = "date")
    @Mapping(source = ".", target = "customer")
    Order getOrder(OrderDTO dto);

    default Date toDate(OrderDTO dto){
        return Date.valueOf(dto.getOrderDate());
    }

    default Customer getCustomer(OrderDTO dto){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try{
            CustomerDAO dao = AppInitializer.getContext().getBean(CustomerDAO.class);
            dao.setEntityManager(em);
            return dao.get(dto.getCustomerId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Mapping(source = ".", target = "orderDetailPK", qualifiedByName = "pk")
    OrderDetail getOrderDetail(OrderDetailDTO dto);

    @Named("pk")
    default OrderDetailPK toOrderDetailPK(OrderDetailDTO dto){
        return new OrderDetailPK(dto.getOrderId(), dto.getItemCode());
    }
}

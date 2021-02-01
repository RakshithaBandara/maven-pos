package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import lk.ijse.dep.web.pos.dto.OrderDTO;
import lk.ijse.dep.web.pos.entity.Customer;
import lk.ijse.dep.web.pos.entity.Item;
import lk.ijse.dep.web.pos.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityDTOMapper {

    Customer getCustomer(CustomerDTO dto);

    Item getItem(ItemDTO dto);

    CustomerDTO getCustomerDTO(Customer customer);

    ItemDTO getItemDTO(Item item);

    Order getOrder(OrderDTO dto);
}

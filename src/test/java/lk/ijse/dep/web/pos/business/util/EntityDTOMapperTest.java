package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import lk.ijse.dep.web.pos.entity.Customer;
import lk.ijse.dep.web.pos.entity.Item;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EntityDTOMapperTest {

    @Test
    public void getCustomer() {
        EntityDTOMapper mapper = Mappers.getMapper(EntityDTOMapper.class);
        Customer customer = mapper.getCustomer(new CustomerDTO("C001", "Lucky", "Galle"));
        System.out.println(customer);
        assertNotNull(customer);
        assertEquals(customer.getId(), "C001");
        assertEquals(customer.getName(), "Lucky");
        assertEquals(customer.getAddress(), "Galle");
    }

    @Test
    public void getCustomerDTO() {
        EntityDTOMapper mapper = Mappers.getMapper(EntityDTOMapper.class);
        CustomerDTO customer = mapper.getCustomerDTO(new Customer("C001", "Lucky", "Galle"));
        System.out.println(customer);
        assertNotNull(customer);
        assertEquals(customer.getId(), "C001");
        assertEquals(customer.getName(), "Lucky");
        assertEquals(customer.getAddress(), "Galle");
    }

    @Test
    public void getItem() {
        EntityDTOMapper mapper = Mappers.getMapper(EntityDTOMapper.class);
        Item item = mapper.getItem(new ItemDTO("I001", "Mouse", new BigDecimal("500"), 10));
        assertNotNull(item);
        assertEquals(item.getCode(), "I001");
        assertEquals(item.getDescription(), "Mouse");
        assertTrue(item.getUnitPrice().doubleValue() == 500.0);
        assertTrue(item.getQtyOnHand() == 10);
    }

    @Test
    public void getItemDTO() {
        EntityDTOMapper mapper = Mappers.getMapper(EntityDTOMapper.class);
        ItemDTO item = mapper.getItemDTO(new Item("I001", "Mouse", new BigDecimal("500"), 10));
        assertNotNull(item);
        assertEquals(item.getCode(), "I001");
        assertEquals(item.getDescription(), "Mouse");
        assertTrue(item.getUnitPrice().doubleValue() == 500.0);
        assertTrue(item.getQtyOnHand() == 10);
    }
}

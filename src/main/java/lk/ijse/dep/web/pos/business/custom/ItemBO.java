package lk.ijse.dep.web.pos.business.custom;

import lk.ijse.dep.web.pos.business.SuperBO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import lk.ijse.dep.web.pos.entity.Customer;

import java.util.List;

public interface ItemBO extends SuperBO {

    public void saveItem(ItemDTO itemDTO) throws Exception;

    public void updateItem(ItemDTO itemDTO) throws Exception;

    public void deleteItem(String itemCode) throws Exception;

    public List<ItemDTO> findAllItems() throws Exception;

}

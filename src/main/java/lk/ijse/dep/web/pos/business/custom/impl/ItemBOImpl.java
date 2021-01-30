package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.ItemBO;
import lk.ijse.dep.web.pos.dto.ItemDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    @Override
    public void setEntityManager(EntityManager em) {

    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws Exception {

    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws Exception {

    }

    @Override
    public void deleteItem(String itemCode) throws Exception {

    }

    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        return null;
    }
}

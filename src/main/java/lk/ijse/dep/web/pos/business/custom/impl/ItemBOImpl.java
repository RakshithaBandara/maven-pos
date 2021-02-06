package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.ItemBO;
import lk.ijse.dep.web.pos.business.util.DEPTransaction;
import lk.ijse.dep.web.pos.business.util.EntityDTOMapper;
import lk.ijse.dep.web.pos.dao.custom.ItemDAO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import lk.ijse.dep.web.pos.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ItemBOImpl implements ItemBO {

    @Autowired
    private ItemDAO itemDAO;
    private EntityManager em;
    @Autowired
    private EntityDTOMapper mapper;

    public ItemBOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        itemDAO.setEntityManager(em);
    }

    @DEPTransaction
    @Override
    public void saveItem(ItemDTO itemDTO) throws Exception {
        itemDAO.save(mapper.getItem(itemDTO));
    }

    @DEPTransaction
    @Override
    public void updateItem(ItemDTO itemDTO) throws Exception {
        itemDAO.update(mapper.getItem(itemDTO));
    }

    @DEPTransaction
    @Override
    public void deleteItem(String itemCode) throws Exception {
        itemDAO.delete(itemCode);
    }

    @DEPTransaction
    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        return mapper.getItemDTOs(itemDAO.getAll());
    }
}

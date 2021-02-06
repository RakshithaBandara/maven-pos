package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.ItemBO;
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
    public void setEntityManager(EntityManager em) {
        this.em = em;
        itemDAO.setEntityManager(em);
    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws Exception {
        try {
            em.getTransaction().begin();
            itemDAO.save(mapper.getItem(itemDTO));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws Exception {
        try {
            em.getTransaction().begin();
            itemDAO.update(mapper.getItem(itemDTO));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteItem(String itemCode) throws Exception {
        try {
            em.getTransaction().begin();
            itemDAO.delete(itemCode);
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        try {
            em.getTransaction().begin();
            List<Item> items = itemDAO.getAll();
            em.getTransaction().commit();
            return mapper.getItemDTOs(items);
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }
}

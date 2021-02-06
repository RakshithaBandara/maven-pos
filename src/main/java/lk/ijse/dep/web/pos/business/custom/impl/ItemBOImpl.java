package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.ItemBO;
import lk.ijse.dep.web.pos.business.util.EntityDTOMapper;
import lk.ijse.dep.web.pos.dao.custom.ItemDAO;
import lk.ijse.dep.web.pos.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Service
public class ItemBOImpl implements ItemBO {

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private EntityDTOMapper mapper;

    public ItemBOImpl() {
    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws Exception {
        itemDAO.save(mapper.getItem(itemDTO));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws Exception {
        itemDAO.update(mapper.getItem(itemDTO));
    }

    @Override
    public void deleteItem(String itemCode) throws Exception {
        itemDAO.delete(itemCode);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        return mapper.getItemDTOs(itemDAO.getAll());
    }
}

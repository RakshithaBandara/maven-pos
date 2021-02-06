package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.CrudDAOImpl;
import lk.ijse.dep.web.pos.dao.custom.ItemDAO;
import lk.ijse.dep.web.pos.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {

}

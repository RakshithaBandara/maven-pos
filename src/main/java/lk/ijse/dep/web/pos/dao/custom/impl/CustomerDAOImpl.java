package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.CrudDAOImpl;
import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

}

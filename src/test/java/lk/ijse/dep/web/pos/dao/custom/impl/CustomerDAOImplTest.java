package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.util.JPAUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDAOImplTest {

    @Test
    public void getAll() throws Exception {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        customerDAO.setEntityManager(JPAUtil.getEntityManagerFactory().createEntityManager());
        customerDAO.getAll().forEach(System.out::println);
        assertTrue(customerDAO.getAll().size()> 0);
    }
}

package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.dao.DAOFactory;
import lk.ijse.dep.web.pos.dao.DAOTypes;
import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO;
    private EntityManager em;

    public CustomerBOImpl(){
        customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        customerDAO.setEntityManager(em);
    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {

    }

    @Override
    public List<Customer> findAllCustomers() throws Exception {
        return null;
    }
}

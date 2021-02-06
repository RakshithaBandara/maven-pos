package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.business.util.EntityDTOMapper;
import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    private EntityManager em;
    @Autowired
    private EntityDTOMapper mapper;

    public CustomerBOImpl() {

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
            customerDAO.save(mapper.getCustomer(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.update(mapper.getCustomer(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.delete(customerId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        try {
            em.getTransaction().begin();
            List<CustomerDTO> customerDTOs = mapper.getCustomerDTOs(customerDAO.getAll());
            em.getTransaction().commit();
            return customerDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}

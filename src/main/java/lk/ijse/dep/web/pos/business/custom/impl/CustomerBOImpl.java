package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.business.util.EntityDTOMapper;
import lk.ijse.dep.web.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private EntityDTOMapper mapper;

    public CustomerBOImpl() {

    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
        customerDAO.save(mapper.getCustomer(dto));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        customerDAO.update(mapper.getCustomer(dto));
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        customerDAO.delete(customerId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        return mapper.getCustomerDTOs(customerDAO.getAll());
    }
}

package lk.ijse.dep.web.pos.business.custom.impl;

import lk.ijse.dep.web.pos.business.custom.CustomerBO;
import lk.ijse.dep.web.pos.business.util.EntityDTOMapper;
import lk.ijse.dep.web.pos.dao.CustomerDAO;
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
        customerDAO.save(mapper.getCustomer(dto));
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        customerDAO.deleteById(customerId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        System.out.println(customerDAO.findCustomerNames("Kadawatha", "U"));
//        customerDAO.readCustomerByNameLike("S%").forEach(System.out::println);
        return mapper.getCustomerDTOs(customerDAO.findAll());
    }
}

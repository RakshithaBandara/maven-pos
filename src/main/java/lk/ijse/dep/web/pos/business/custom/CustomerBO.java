package lk.ijse.dep.web.pos.business.custom;

import lk.ijse.dep.web.pos.business.SuperBO;
import lk.ijse.dep.web.pos.dto.CustomerDTO;
import lk.ijse.dep.web.pos.entity.Customer;

import java.util.List;

public interface CustomerBO extends SuperBO {

    public void saveCustomer(CustomerDTO customerDTO) throws Exception;

    public void updateCustomer(CustomerDTO customerDTO) throws Exception;

    public void deleteCustomer(String customerId) throws Exception;

    public List<Customer> findAllCustomers() throws Exception;
}

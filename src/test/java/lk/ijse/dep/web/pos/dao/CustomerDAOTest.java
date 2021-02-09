package lk.ijse.dep.web.pos.dao;

import lk.ijse.dep.web.pos.WebRootConfig;
import lk.ijse.dep.web.pos.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebRootConfig.class})
public class CustomerDAOTest {

    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void findCustomersByNameLikeOrAddressLike() {
        Page<Customer> page = customerDAO.findCustomersByNameLikeOrAddressLike("K%", "K%", PageRequest.of(1, 2));
        page.forEach(System.out::println);
//        customers.forEach(System.out::println);
    }
}

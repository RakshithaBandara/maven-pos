package lk.ijse.dep.web.pos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = WebRootConfig.class)
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Test
    public void countOrdersByDate(){
        assertEquals(orderDAO.countOrdersByDate(Date.valueOf("2021-01-13")), 12);
    }

    @Test
    public void getOrdersByDate(){
        orderDAO.getOrdersByDate(Date.valueOf("2021-01-13")).forEach(System.out::println);
    }

    @Test
    public void getOrdersByDate2(){
        orderDAO.getOrdersByDate2(Date.valueOf("2021-01-13")).forEach(c->c.printDetails());
    }
}

package lk.ijse.dep.web.pos.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = WebRootConfig.class)
public class ItemDAOTest {

    @Autowired
    private ItemDAO itemDAO;

    @Test
    public void queryItemByQtyOnHandLessThanEqual() {
        itemDAO.queryItemByQtyOnHandLessThanEqual(5).forEach(System.out::println);
    }

    @Test
    public void immediateStock(){
        itemDAO.immediateStock().forEach(System.out::println);
    }

    @Test
    public void getMostSellingItems(){
        itemDAO.getMostSellingItems(Date.valueOf("2021-01-13"), Date.valueOf("2021-01-13"))
                .forEach(c-> c.printDetails());
    }
}

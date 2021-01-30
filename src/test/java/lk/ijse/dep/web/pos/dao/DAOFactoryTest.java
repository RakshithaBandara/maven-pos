package lk.ijse.dep.web.pos.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class DAOFactoryTest {

    @Test
    public void getInstance() {
        assertEquals(DAOFactory.getInstance() , DAOFactory.getInstance());
    }
}

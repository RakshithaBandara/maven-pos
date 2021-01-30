package lk.ijse.dep.web.pos.util;

import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

public class JPAUtilTest {

    @Test
    public void getDataSource() {
        assertNotNull(JPAUtil.getDataSource());
    }


    @Test
    public void getEntityManagerFactory() {
        assertNotNull(JPAUtil.getEntityManagerFactory());
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        assertNotNull(entityManager);
        if (entityManager != null){
            entityManager.close();
        }
    }

}

package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.custom.QueryDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

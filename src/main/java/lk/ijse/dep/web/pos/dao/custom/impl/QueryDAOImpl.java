package lk.ijse.dep.web.pos.dao.custom.impl;

import lk.ijse.dep.web.pos.dao.custom.QueryDAO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class QueryDAOImpl implements QueryDAO {

    @Override
    public void setEntityManager(EntityManager em) {

    }
}

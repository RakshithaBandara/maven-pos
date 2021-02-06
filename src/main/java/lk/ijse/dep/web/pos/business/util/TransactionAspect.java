package lk.ijse.dep.web.pos.business.util;

import lk.ijse.dep.web.pos.business.SuperBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@Aspect
public class TransactionAspect {

    @Before("@annotation(lk.ijse.dep.web.pos.business.util.DEPTransaction)")
    public void beforeServiceMethod(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManager();
        em.getTransaction().begin();
    }

    @After("@annotation(lk.ijse.dep.web.pos.business.util.DEPTransaction)")
    public void afterServiceMethod(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManager();
        em.getTransaction().commit();
    }

    @AfterThrowing("@annotation(lk.ijse.dep.web.pos.business.util.DEPTransaction)")
    public void afterServiceMethodWithExp(JoinPoint jp){
        EntityManager em = ((SuperBO) (jp.getThis())).getEntityManager();
        em.getTransaction().rollback();
    }

}

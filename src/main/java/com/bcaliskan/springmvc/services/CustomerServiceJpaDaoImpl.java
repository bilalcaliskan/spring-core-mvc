package com.bcaliskan.springmvc.services;

import com.bcaliskan.springmvc.domain.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService {

    private EntityManagerFactory emf;

    /*
    Below annotation injects entityManagerFactory bean into productServiceJpaDaoImpl bean.
    We used EntityManagerFactory because it is thread safe, while EntityManager is not.
    */
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // merge method creates an object if it does not exists, or updates if exists.
        Customer savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();

        // version property on that returned object will be updated
        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }

}

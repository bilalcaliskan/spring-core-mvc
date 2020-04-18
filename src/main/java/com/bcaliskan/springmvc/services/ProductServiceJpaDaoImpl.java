package com.bcaliskan.springmvc.services;

import com.bcaliskan.springmvc.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService {

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

        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // merge method creates an object if it does not exists, or updates if exists.
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();

        // version property on that returned object will be updated
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }

}

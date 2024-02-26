package com.example.BackendCrud.UserProduct.management.system.services;

import com.example.BackendCrud.UserProduct.management.system.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public List<Product> findListOfProducts(){
        em.getTransaction().begin();
        TypedQuery<Product> q = em.createNamedQuery("findAllProducts", Product.class);
        List<Product> list = q.getResultList();
        em.getTransaction().commit();

        em.close();
        return list;
    }

    public Product findProductById(String productId){
        TypedQuery<Product> q = em.createNamedQuery("findProductById", Product.class);
        q.setParameter("id", productId);
        return q.getSingleResult();
    }
}

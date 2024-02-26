package com.example.BackendCrud.UserProduct.management.system.services;

import com.example.BackendCrud.UserProduct.management.system.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public User findUserById(String userId){
        TypedQuery<User> q = em.createNamedQuery("findUserById", User.class);
        q.setParameter("id", userId);
        return q.getSingleResult(); //may be null update to optional
    }
    public User findUserByUserName(String name){
        TypedQuery<User> q = em.createNamedQuery("findUserByUsername", User.class);
        q.setParameter("username", name);
        return q.getSingleResult(); //may be null update to optional
    }
}

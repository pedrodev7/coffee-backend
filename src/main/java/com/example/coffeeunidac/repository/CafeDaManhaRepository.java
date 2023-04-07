package com.example.coffeeunidac.repository;

import org.springframework.stereotype.Repository;

import com.example.coffeeunidac.model.CafeDaManha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CafeDaManhaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void save(CafeDaManha cafeDaManha){
        entityManager.createNativeQuery("INSERT INTO cafedamanha_tb (data_do_cafe) values (?)")
            .setParameter(1, cafeDaManha.getDataDoCafe())
            .executeUpdate();
    }
}

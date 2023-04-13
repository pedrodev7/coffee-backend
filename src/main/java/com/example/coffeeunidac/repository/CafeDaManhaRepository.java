package com.example.coffeeunidac.repository;

import java.util.ArrayList;
import java.util.List;

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

    public List<CafeDaManha> findAll() {
        return new ArrayList<>(
                entityManager.createNativeQuery("SELECT * FROM cafedamanha_tb ORDER BY data_do_cafe DESC", CafeDaManha.class).getResultList());
    }

    public List<CafeDaManha> findById(Long id) {
        return new ArrayList<>(
                entityManager.createNativeQuery("SELECT * FROM cafedamanha_tb where id = ?", CafeDaManha.class)
                .setParameter(1, id)
                .getResultList());
    }

    public void removeById(Long id){
        String sql = "DELETE FROM cafedamanha_tb "
            + "where id = ?";
            entityManager.createNativeQuery(sql)
                .setParameter(1, id)
                .executeUpdate();
    }
}

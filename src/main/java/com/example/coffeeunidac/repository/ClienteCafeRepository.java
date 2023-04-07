package com.example.coffeeunidac.repository;

import org.springframework.stereotype.Repository;

import com.example.coffeeunidac.model.ClienteCafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteCafeRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void save(ClienteCafe clienteCafe){
        entityManager.createNativeQuery("INSERT INTO cliente_cafe (id_cliente,id_cafe,nome_do_produto) VALUES (?,?,?)")
            .setParameter(1, clienteCafe.getIdCliente())
            .setParameter(2, clienteCafe.getIdCafe())
            .setParameter(3, clienteCafe.getNomeDoProduto())
            .executeUpdate();
    }

}

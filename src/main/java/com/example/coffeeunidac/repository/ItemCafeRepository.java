package com.example.coffeeunidac.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.coffeeunidac.model.ItemCafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ItemCafeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ItemCafe itemCafe) {
        entityManager.createNativeQuery("INSERT INTO itemcafe_tb (idcliente,idcafe,nomedoproduto) VALUES (?,?,?)")
                .setParameter(1, itemCafe.getIdCliente())
                .setParameter(2, itemCafe.getIdCafe())
                .setParameter(3, itemCafe.getNomeDoProduto())
                .executeUpdate();
    }

    public List<ItemCafe> findItemCafeById(Long id) {

        String sql = "select * from itemcafe_tb it "
                + "inner join cafedamanha_tb ct on it.idcafe = ct.id "
                + "inner join cliente_tb c on it.idcliente = c.id "
                + "where it.idcafe = ?";

        List<ItemCafe> listaDeItens = entityManager.createNativeQuery(sql, ItemCafe.class)
                .setParameter(1, id)
                .getResultList();

        return listaDeItens;
    }
}

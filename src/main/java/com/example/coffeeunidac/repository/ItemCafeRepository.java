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
        entityManager.createNativeQuery("INSERT INTO cliente_cafe (idcliente,idcafe,nomedoproduto) VALUES (?,?,?)")
                .setParameter(1, itemCafe.getIdCliente())
                .setParameter(2, itemCafe.getIdCafe())
                .setParameter(3, itemCafe.getNomeDoProduto())
                .executeUpdate();
    }

    public List<ItemCafe> findItemCafeById(Long id) {

        String sql = "select * from cliente_cafe cc "
                + "inner join cafedamanha_tb ct on cc.idcafe = ct.id "
                + "inner join cliente_tb c on cc.idcliente = c.id "
                + "where cc.idcafe = ?";

        List<ItemCafe> listaDeItens = entityManager.createNativeQuery(sql, ItemCafe.class)
                .setParameter(1, id)
                .getResultList();

        return listaDeItens;
    }
}

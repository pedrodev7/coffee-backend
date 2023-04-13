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
        entityManager.createNativeQuery("INSERT INTO itemcafe_tb (id_cliente,id_cafe,nome_do_produto) VALUES (?,?,?)")
                .setParameter(1, itemCafe.getId_cliente())
                .setParameter(2, itemCafe.getId_cafe())
                .setParameter(3, itemCafe.getNome_do_produto())
                .executeUpdate();
    }

    public List<ItemCafe> findItemCafeById(Long id) {

        String sql = "select * from itemcafe_tb it "
                + "inner join cafedamanha_tb ct on it.id_cafe = ct.id "
                + "inner join cliente_tb c on it.id_cliente = c.id "
                + "where it.id_cafe = ?";

        List<ItemCafe> listaDeItens = entityManager.createNativeQuery(sql, ItemCafe.class)
                .setParameter(1, id)
                .getResultList();

        return listaDeItens;
    }

    public void deleteItemCafeById(Long idCliente, String nomeProduto) {
        String sql = "DELETE FROM itemcafe_tb "
            + "where id_cafe = ? AND nome_do_produto = ?";

            entityManager.createNativeQuery(sql)
                .setParameter(1, idCliente)
                .setParameter(2, nomeProduto)
                .executeUpdate();
    }

    public void marcarItemCafeById(Long idCliente, String nomeProduto) {
        String sql = "UPDATE itemcafe_tb SET trouxe = ? where id_cafe = ? AND nome_do_produto = ?";

            entityManager.createNativeQuery(sql)
                .setParameter(1, true)
                .setParameter(2, idCliente)
                .setParameter(3, nomeProduto)
                .executeUpdate();
    }
}

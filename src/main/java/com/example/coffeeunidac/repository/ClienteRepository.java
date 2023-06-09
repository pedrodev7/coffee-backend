package com.example.coffeeunidac.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.coffeeunidac.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Cliente cliente) {
        entityManager.createNativeQuery("INSERT INTO cliente_tb (nome, cpf) values (?,?)")
                .setParameter(1, cliente.getNome())
                .setParameter(2, cliente.getCpf())
                .executeUpdate();
    }

    public List<Cliente> findAll() {
        return new ArrayList<>(
                entityManager.createNativeQuery("SELECT * FROM cliente_tb", Cliente.class).getResultList());
    }

    public List<Cliente> findByCpf(String cpf) {
        return entityManager.createNativeQuery("SELECT * from cliente_tb where cpf = ?", Cliente.class)
                .setParameter(1, cpf)
                .getResultList();
    }

    public List<Cliente> findById(Long id) {
        return entityManager.createNativeQuery("SELECT * from cliente_tb where id = ?", Cliente.class)
                .setParameter(1, id)
                .getResultList();
    }

    public void update(Cliente cliente) {
        entityManager.createNativeQuery("UPDATE cliente_tb SET nome = ?, cpf = ? where id = ?")
                .setParameter(1, cliente.getNome())
                .setParameter(2, cliente.getCpf())
                .setParameter(3, cliente.getId())
                .executeUpdate();
    }

    public void deleteById(Long id) {
        entityManager.createNativeQuery("DELETE from cliente_tb where id = ?")
            .setParameter(1, id)
            .executeUpdate();
    }
}

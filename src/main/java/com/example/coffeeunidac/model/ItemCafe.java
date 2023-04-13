package com.example.coffeeunidac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "itemcafe_tb", uniqueConstraints = @UniqueConstraint(columnNames = { "id_cafe", "nome_do_produto" }))
public class ItemCafe {

    @Id
    private Long id_cafe;

    private Long id_cliente;

    @Id
    private String nome_do_produto;

    private Boolean trouxe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cafe", insertable = false, updatable = false)
    private CafeDaManha cafeDaManha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    public ItemCafe() {

    }

    public ItemCafe(Long id_cafe, Long id_cliente, String nome_do_produto) {
        this.trouxe = false;
        this.id_cafe = id_cafe;
        this.id_cliente = id_cliente;
        this.nome_do_produto = nome_do_produto;
    }

    public Long getId_cafe() {
        return id_cafe;
    }

    public void setId_cafe(Long id_cafe) {
        this.id_cafe = id_cafe;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_do_produto() {
        return nome_do_produto;
    }

    public void setNome_do_produto(String nome_do_produto) {
        this.nome_do_produto = nome_do_produto;
    }

    public CafeDaManha getCafeDaManha() {
        return cafeDaManha;
    }

    public void setCafeDaManha(CafeDaManha cafeDaManha) {
        this.cafeDaManha = cafeDaManha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getTrouxe() {
        return trouxe;
    }

    public void setTrouxe(Boolean trouxe) {
        this.trouxe = trouxe;
    }
    
}

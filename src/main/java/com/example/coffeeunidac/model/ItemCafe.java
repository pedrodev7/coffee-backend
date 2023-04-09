package com.example.coffeeunidac.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "itemcafe_tb", uniqueConstraints = @UniqueConstraint(columnNames = { "idCafe", "nomeDoProduto" }))
public class ItemCafe {

    @Id
    @Column(name = "idcafe")
    private Long idCafe;

    @Id
    @Column(name = "idcliente")
    private Long idCliente;

    @Id
    @Column(name = "nomedoproduto")
    private String nomeDoProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcafe", insertable = false, updatable = false)
    private CafeDaManha cafeDaManha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente", insertable = false, updatable = false)
    private Cliente cliente;

    public ItemCafe(Long idCafe, Long idCliente, String nomeDoProduto) {
        this.idCafe = idCafe;
        this.idCliente = idCliente;
        this.nomeDoProduto = nomeDoProduto;
    }

    public ItemCafe(String nomeDoProduto, CafeDaManha cafeDaManha, Cliente cliente) {
        this.nomeDoProduto = nomeDoProduto;
        this.cafeDaManha = cafeDaManha;
        this.cliente = cliente;
    }

    public ItemCafe() {

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

    public Long getIdCafe() {
        return idCafe;
    }

    public void setIdCafe(Long idCafe) {
        this.idCafe = idCafe;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

}

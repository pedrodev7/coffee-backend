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
@Table(name = "cliente_cafe", uniqueConstraints = @UniqueConstraint(columnNames = {"id_cafe", "nomeDoProduto"}))
public class ClienteCafe {
    
    @Id
    @Column(name = "id_cafe")
    private Long idCafe;

    @Id
    @Column(name = "id_cliente")
    private Long idCliente;

    @Id
    private String nomeDoProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cafe", insertable = false, updatable = false)
    private CafeDaManha cafeDaManha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    public ClienteCafe(Long idCafe, Long idCliente, String nomeDoProduto) {
        this.idCafe = idCafe;
        this.idCliente = idCliente;
        this.nomeDoProduto = nomeDoProduto;
    }

    public ClienteCafe(){

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

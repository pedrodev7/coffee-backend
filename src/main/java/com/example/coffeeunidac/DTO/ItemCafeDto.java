package com.example.coffeeunidac.DTO;

import java.time.LocalDate;

public class ItemCafeDto {

    private ClienteDto cliente;
    private String nomeDoProduto;
    private LocalDate diaDoCafeDaManha;
    private Boolean trouxe;

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDiaDoCafeDaManha() {
        return diaDoCafeDaManha;
    }

    public void setDiaDoCafeDaManha(LocalDate diaDoCafeDaManha) {
        this.diaDoCafeDaManha = diaDoCafeDaManha;
    }

    public Boolean getTrouxe() {
        return trouxe;
    }

    public void setTrouxe(Boolean trouxe) {
        this.trouxe = trouxe;
    }

}

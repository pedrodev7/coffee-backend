package com.example.coffeeunidac.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cafedamanha_tb")
public class CafeDaManha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDoCafe;

    @OneToMany(mappedBy = "cafeDaManha")
    private List<ItemCafe> itemCafeDaManha;

    public CafeDaManha() {
    }

    public CafeDaManha(LocalDate dataDoCafe) {
        this.dataDoCafe = dataDoCafe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataDoCafe() {
        return dataDoCafe;
    }

    public void setDataDoCafe(LocalDate dataDoCafe) {
        this.dataDoCafe = dataDoCafe;
    }
}

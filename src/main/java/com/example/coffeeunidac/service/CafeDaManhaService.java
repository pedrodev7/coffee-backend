package com.example.coffeeunidac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeunidac.model.CafeDaManha;
import com.example.coffeeunidac.repository.CafeDaManhaRepository;

import jakarta.transaction.Transactional;

@Service
public class CafeDaManhaService {
    
    @Autowired
    private CafeDaManhaRepository cafeDaManhaRepository;

    @Transactional
    public void criarCafeDaManha(CafeDaManha cafeDaManha){
        cafeDaManhaRepository.save(cafeDaManha);
    }

}

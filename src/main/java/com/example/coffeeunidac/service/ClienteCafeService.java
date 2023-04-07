package com.example.coffeeunidac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeunidac.model.ClienteCafe;
import com.example.coffeeunidac.repository.ClienteCafeRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteCafeService {
    
    @Autowired
    private ClienteCafeRepository clienteCafeRepository;

    @Transactional
    public void adicionarProdutoNoCafeDaManha(ClienteCafe clienteCafe){
        clienteCafeRepository.save(clienteCafe);
    }
}

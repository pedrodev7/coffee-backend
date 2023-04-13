package com.example.coffeeunidac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeunidac.model.ItemCafe;
import com.example.coffeeunidac.repository.ItemCafeRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemCafeService {
    
    @Autowired
    private ItemCafeRepository itemCafeRepository;

    @Transactional
    public void adicionarProdutoNoCafeDaManha(ItemCafe itemCafe){
        itemCafeRepository.save(itemCafe);
    }

    @Transactional
    public List<ItemCafe> listAllitensCafeById(Long id){
        return itemCafeRepository.findItemCafeById(id);
    }

    @Transactional
    public void removerProdutoNoCafeDaManha(Long idCliente, String nomeProduto){
        itemCafeRepository.deleteItemCafeById(idCliente, nomeProduto);
    }

    @Transactional
    public void trazerItemDoCafeDaManha(Long idCliente, String nomeProduto){
        itemCafeRepository.marcarItemCafeById(idCliente, nomeProduto);
    }
}

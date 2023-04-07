package com.example.coffeeunidac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeunidac.model.ClienteCafe;
import com.example.coffeeunidac.service.ClienteCafeService;

@RestController
@RequestMapping("/itemCafe")
public class ClienteCafeController {
    
    @Autowired
    private ClienteCafeService clienteCafeService;

    @PostMapping("/addProdutoNoCafe")
    public ResponseEntity<String> adicionarProdutoNoCafeDaManha(@RequestBody ClienteCafe clienteCafe){
        System.out.println(">>>>>>>>>>>>" + clienteCafe.getIdCafe());
        System.out.println(">>>>>>>>>>>>" + clienteCafe.getIdCliente());
        System.out.println(">>>>>>>>>>>>" + clienteCafe.getNomeDoProduto());
        clienteCafeService.adicionarProdutoNoCafeDaManha(clienteCafe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

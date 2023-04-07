package com.example.coffeeunidac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeunidac.model.CafeDaManha;
import com.example.coffeeunidac.service.CafeDaManhaService;

@RestController
@RequestMapping("/cafeDaManha")
public class CafeDaManhaController {

    @Autowired
    private CafeDaManhaService cafeDaManhaService;

    @PostMapping("/addCafe")
    public ResponseEntity<String> criarCafe(@RequestBody CafeDaManha cafeDaManha) {
        try {
            cafeDaManhaService.criarCafeDaManha(cafeDaManha);
            return ResponseEntity.status(HttpStatus.CREATED).body("Café da Manha Criado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .build();
        }
    }
}

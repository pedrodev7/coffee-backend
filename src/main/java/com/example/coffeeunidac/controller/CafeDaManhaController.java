package com.example.coffeeunidac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listarCafe")
    public ResponseEntity<List<CafeDaManha>> listarTodosOsCafes() {
        try {
            List<CafeDaManha> cafe = cafeDaManhaService.listarCafeDaManha();
            return ResponseEntity.ok(cafe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}/listarCafe")
    public ResponseEntity<List<CafeDaManha>> listarTodosOsCafes(@PathVariable Long id) {
        try {
            List<CafeDaManha> cafe = cafeDaManhaService.listarCafeDaManhaById(id);
            return ResponseEntity.ok(cafe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("{id}/removerCafe")
    public ResponseEntity<String> removerCafe(@PathVariable Long id) {

        try {
            cafeDaManhaService.removerCafeDaManha(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Exclua todos os itens do Café Antes de Excluir um Café da Manha.");
        }
    }
}

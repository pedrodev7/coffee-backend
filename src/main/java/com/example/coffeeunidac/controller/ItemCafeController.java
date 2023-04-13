package com.example.coffeeunidac.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeunidac.DTO.ClienteDto;
import com.example.coffeeunidac.DTO.ItemCafeDto;
import com.example.coffeeunidac.model.ItemCafe;
import com.example.coffeeunidac.service.ItemCafeService;

@RestController
@RequestMapping("/itemCafe")
public class ItemCafeController {

    @Autowired
    private ItemCafeService itemCafeService;

    @PostMapping("/addItemNoCafe")
    public ResponseEntity<String> adicionarProdutoNoCafeDaManha(@RequestBody ItemCafe itemCafe) {      
        itemCafeService.adicionarProdutoNoCafeDaManha(itemCafe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/exibirCafe")
    public ResponseEntity<List<ItemCafeDto>> obterCafe(@PathVariable Long id) {
        List<ItemCafe> lista = itemCafeService.listAllitensCafeById(id);
        List<ItemCafeDto> listaDeItensDoCafe = new ArrayList<>();

        for (ItemCafe cc : lista) {
            ItemCafeDto itens = new ItemCafeDto();
            ClienteDto c1 = new ClienteDto();

            c1.setNome(cc.getCliente().getNome());
            c1.setCpf(cc.getCliente().getCpf());
            itens.setDiaDoCafeDaManha(cc.getCafeDaManha().getDataDoCafe());
            itens.setCliente(c1);
            itens.setNomeDoProduto(cc.getNome_do_produto());
            itens.setTrouxe(cc.getTrouxe());

            listaDeItensDoCafe.add(itens);
        }

        return ResponseEntity.ok(listaDeItensDoCafe);
    }


    @DeleteMapping("/{id}/{nomeProduto}/delete")
    public ResponseEntity<String> removerProdutoDoCafe(@PathVariable Long id, @PathVariable String nomeProduto){
        itemCafeService.removerProdutoNoCafeDaManha(id, nomeProduto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/{nomeProduto}/trazer")
    public ResponseEntity<String> trazerItemDoCafeDaManha(@PathVariable Long id, @PathVariable String nomeProduto){
        itemCafeService.trazerItemDoCafeDaManha(id, nomeProduto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

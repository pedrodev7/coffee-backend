package com.example.coffeeunidac.controller;

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

import com.example.coffeeunidac.model.Cliente;
import com.example.coffeeunidac.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/addCliente")
    public ResponseEntity<String> addCliente(@Valid @RequestBody Cliente cliente) {
        try {
            if (cliente.getCpf().replaceAll("[^0-9]+", "").length() != 11) {
                return ResponseEntity
                        .badRequest()
                        .body("CPF não atende os requisitos de 11 Caracteres validos.");
            }
            this.clienteService.addCliente(cliente);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Cadastro Realizado");
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarTodosOsClientes() {
        try {
            List<Cliente> cliente = clienteService.listAllClientes();
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{cpf}/getCliente")
    public ResponseEntity<Cliente> getClienteByCpf(@PathVariable String cpf) {
        try {
            List<Cliente> cliente = clienteService.getCliente(cpf);
            return ResponseEntity.ok(cliente.get(0));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}/clienteId")
    public ResponseEntity<Cliente> getClienteId(@PathVariable Long id) {
        try {
            List<Cliente> cliente = clienteService.getClienteById(id);
            return ResponseEntity.ok(cliente.get(0));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}/editarCliente")
    public ResponseEntity<String> editarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        try {
            List<Cliente> cliente = clienteService.getClienteById(id);

            if (cliente.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Cliente não está na base de dados!");
            }

            clienteAtualizado.setId(id);
            clienteService.atualizarCliente(clienteAtualizado);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/removerCliente")
    public ResponseEntity<String> removerCliente(@PathVariable Long id) {
        try {
            List<Cliente> cliente = clienteService.getClienteById(id);

            if (cliente.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Cliente não está na base de dados!");
            }

            clienteService.removerClienteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}

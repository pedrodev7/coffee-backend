package com.example.coffeeunidac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeunidac.model.Cliente;
import com.example.coffeeunidac.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void addCliente(Cliente cliente){
        clienteRepository.adicionarCliente(cliente);
    }

    @Transactional
    public List<Cliente> listAllClientes(){
        return clienteRepository.listarTodosOsClientes();
    }

    @Transactional
    public List<Cliente> getCliente(String cpf){
        return clienteRepository.buscarClientePorCpf(cpf);
    }

    @Transactional
    public List<Cliente> getClienteById(Long id){
        return clienteRepository.buscarClientePorId(id);
    }

    @Transactional
    public void atualizarCliente(Cliente cliente){
        clienteRepository.atualizarCliente(cliente);
    }

    @Transactional
    public void removerClienteById(Long id){
        clienteRepository.removerClienteById(id);
    }
}

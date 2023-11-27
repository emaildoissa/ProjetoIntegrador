/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senac.Projeto.service;

import com.br.senac.Projeto.data.ClienteEntity;
import com.br.senac.Projeto.data.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteEntity criarCliente(ClienteEntity clienteEntity) {
    
    clienteRepository.save(clienteEntity);
    return clienteEntity;
    }    

    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }
    
    public ClienteEntity getClienteId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }
    
     public List<ClienteEntity> encontrarClientesPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
}

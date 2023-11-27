/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senac.Projeto.service;

import com.br.senac.Projeto.data.EnderecoEntity;
import com.br.senac.Projeto.data.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;
    
     public EnderecoEntity criarEndereco(EnderecoEntity enderecoEntity) {
        enderecoRepository.save(enderecoEntity);
        return enderecoEntity;
    }
    
    public List<EnderecoEntity> listarTodosFilmes() {
        return enderecoRepository.findAll();
    }
    
}

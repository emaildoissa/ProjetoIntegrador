package com.br.senac.Projeto.service;

import com.br.senac.Projeto.data.OrdemEntity;
import com.br.senac.Projeto.data.OrdemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemService {
    @Autowired
    OrdemRepository ordemRepository;
    
    public OrdemEntity criarOrdem(OrdemEntity ordemEntity) {
    
    ordemRepository.save(ordemEntity);
    return ordemEntity;
    } 
    public List<OrdemEntity> listarTodasOrdens() {
        return ordemRepository.findAll();
    }
    public OrdemEntity getOrdemId(Integer id) {
        return ordemRepository.findById(id).orElse(null);
    }
    public void deletarOrdem(Integer ordemId) {
        OrdemEntity film = getOrdemId(ordemId);
        ordemRepository.deleteById(film.getId());
    } 
    public OrdemEntity getOrdemByClienteId(Integer ClienteId){
        return ordemRepository.findByClienteId(ClienteId);
    }
    public OrdemEntity atualizarOrdem(Integer ordemId, OrdemEntity ordemRequest){
        OrdemEntity ordemEntity = getOrdemId(ordemId);
        ordemEntity.setDefeito(ordemRequest.getDefeito());       
        ordemEntity.setMarca(ordemRequest.getMarca());
        ordemEntity.setObs(ordemRequest.getObs());
        ordemEntity.setTipo(ordemRequest.getTipo());
        ordemRepository.save(ordemEntity);
        return ordemEntity;
    }
    
    public List<OrdemEntity> listarOrdensPorCliente(String nomeCliente) {
        return ordemRepository.findByCliente_Nome(nomeCliente);
    }
}

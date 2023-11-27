package com.br.senac.Projeto.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
    List<ClienteEntity> findByNomeContainingIgnoreCase(String nome);
   
}

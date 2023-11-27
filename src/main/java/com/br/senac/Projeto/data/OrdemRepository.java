package com.br.senac.Projeto.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdemRepository extends JpaRepository<OrdemEntity, Integer> {
    OrdemEntity findByClienteId(Integer clienteId);
    @Query("SELECT o FROM OrdemEntity o WHERE o.cliente.nome = :nomeCliente")
    List<OrdemEntity> findByCliente_Nome(String nomeCliente);
}

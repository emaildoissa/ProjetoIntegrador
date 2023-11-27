package com.br.senac.Projeto.data;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ordem")

public class OrdemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    
    private String marca;
    private String tipo;
    private String acessorios;
    private String defeito;
    private String obs;
    
    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
}

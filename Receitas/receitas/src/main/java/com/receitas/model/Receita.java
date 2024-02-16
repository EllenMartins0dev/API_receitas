package com.receitas.model;

import java.util.*;

import com.receitas.Enum.AvaliacaoEnum;
import com.receitas.Enum.CategoriaEnum;
import com.receitas.Enum.DificuldadeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100,nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingrediente_id")
    private List<Ingrediente> ingredientes;

    @Column(nullable = false)
    private int tempoDePreparo;

    // ligação de 1 para muitos
    @OneToMany(cascade = CascadeType.ALL)
    // cria uma coluna (pra saber qual é o identificador da tabela)
    @JoinColumn(name = "etapa_preparo_id")
    private List<EtapaPreparo> etapasPreparo; 

    @Column(length = 100,nullable = false)
    private String autor;

    @Column(length = 100,nullable = false)
    private String rendimento; 

    @Column(length = 100,nullable = false)
    private CategoriaEnum categoria; 

    private DificuldadeEnum dificuldade; 

    private AvaliacaoEnum avaliacao;
    
    
    @Column(length = 100,nullable = false) 
    private String observacao;
}

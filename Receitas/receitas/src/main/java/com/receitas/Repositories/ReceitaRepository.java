package com.receitas.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import com.receitas.Enum.DificuldadeEnum;
import com.receitas.Enum.CategoriaEnum;
import com.receitas.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

   
    List<Receita> findByCategoria(@Param("categoria") CategoriaEnum categoria);

    List<Receita> findByDificuldade(DificuldadeEnum dificuldade);

    List<Receita> findByNomeContainingIgnoreCase(String nome);

    List<Receita> findByTempoDePreparoLessThan(int tempo);

}

package com.receitas;

import com.receitas.Enum.CategoriaEnum;
import com.receitas.Enum.DificuldadeEnum;

import org.springframework.web.bind.annotation.RestController;

import com.receitas.Repositories.ReceitaRepository;
import com.receitas.model.Receita;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin("")

public class ReceitaController {
    private final ReceitaRepository rp;

    public ReceitaController(ReceitaRepository rp) {
        this.rp = rp;
    }

    @GetMapping
    public List<Receita> buscaReceitas() {
        return this.rp.findAll();
    }

    @GetMapping("/categoria")
    public List<Receita> buscaReceitasPorCategoria(@RequestParam("categoria") CategoriaEnum categoria) {
        return this.rp.findByCategoria(categoria);
    }

    @GetMapping("/dificuldade")
    public List<Receita> buscaReceitasPorDificuldade(@RequestParam("dificuldade") DificuldadeEnum dificuldade) {
        return this.rp.findByDificuldade(dificuldade);
    }

    @GetMapping("/nome")
    public List<Receita> buscaReceitasPorNome(@RequestParam("nome") String nome) {
        return this.rp.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/tempo_de_preparo")
public List<Receita> buscaReceitasPorTempoDePreparo() {
    int tempoMaximo = 30; 
    return this.rp.findByTempoDePreparoLessThan(tempoMaximo);
}

}

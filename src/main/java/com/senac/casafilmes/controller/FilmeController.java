package com.senac.casafilmes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.senac.casafilmes.model.*;

@Controller 
public class FilmeController {
    private List<Filme> filmes = new ArrayList<>();
    private List<Analise> analises = new ArrayList<>();

    @GetMapping("/detalhes-filme")
    public String mostraDetalhes(@RequestParam("id") int id, Model model){
        Filme f = filmes.stream().filter(filme -> filme.getId() == id).findFirst().orElse(null);
        List<Analise> analisesDoFilme = analises.stream().filter(a -> a.getFilme() != null && a.getFilme().getId() == id).toList();
        
        model.addAttribute("analises", analisesDoFilme);
        model.addAttribute("filme", f);

        return "detalhes-filme";
    }


    @GetMapping("/lista-filmes")
    public String mostrarLista(Model model){

        model.addAttribute("filmes", filmes);

        return "lista-filmes";
    }


    @GetMapping("/cadastro-filme")
    public String mostrarFormulario(Model model){
        model.addAttribute("filme", new Filme());
        return "cadastro-filme";
    }


    @PostMapping("/cadastro-filme")
    public String processarFormulario(Model model, @ModelAttribute Filme filme){
        model.addAttribute("filme", filme);
        filmes.add(filme);
        return "redirect:/detalhes-filme?id=" + filme.getId();
    }

    
    @GetMapping("/cadastrar-analise")
    public String exibirFormularioAnalise(@RequestParam("id") int id, Model model){
        Filme f = filmes.stream().filter(filme -> filme.getId() == id).findFirst().orElse(null);
        model.addAttribute("filme", f);
        model.addAttribute("analise", new Analise());
        return "cadastrar-analise";
    }

    @PostMapping("/cadastrar-analise")
    public String processarFormularioAnalise(@RequestParam("filmeId") int filmeId, @ModelAttribute Analise analise){
        
        Filme filmeEncontrado = filmes.stream().filter(f -> f.getId() == filmeId).findFirst().orElse(null);
        analise.setFilme(filmeEncontrado);
        analises.add(analise);
        return "redirect:/detalhes-filme?id=" + filmeId;
    }
}

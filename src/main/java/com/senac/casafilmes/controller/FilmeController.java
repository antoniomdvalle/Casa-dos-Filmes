package com.senac.casafilmes.controller;
import com.senac.casafilmes.service.AnaliseService;
import com.senac.casafilmes.service.FilmeService;
import com.senac.casafilmes.model.Filme;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class FilmeController {
    @Autowired 
    FilmeService filmeService;

    @Autowired 
    AnaliseService analiseService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listarFilmes", filmeService.listAllFilmes());
        return "index";
    }

    @GetMapping("/deletarFilme/{id}")
    public String deletarFilme(@PathVariable(value="id") Integer id){
        filmeService.deletarFilme(id);
        return "redirect:/";
    }

    @GetMapping("/criarFilmeForm")
    public String criarFilme(Model model){
        Filme f = new Filme();
        model.addAttribute("filme", f);
        return "inserir";
    }

    @PostMapping("/salvarFilme")
    public String salvarFilme(@Valid @ModelAttribute("filme") Filme f, BindingResult result){
        if (result.hasErrors()){
            return "inserir";
        }
        if (f.getId() == null){
            filmeService.criarFilme(f);
        }else{
            filmeService.atualizarFilme(f.getId(), f);
        }

        return "redirect:/";
    }

    @GetMapping("/atualizarFilmeForm/{id}")
    public String atualizarFilmeForm(@PathVariable(value = "id") Integer id, Model model){
        Filme filme = filmeService.getFilmeId(id);
        model.addAttribute("filme", filme);
        model.addAttribute("listaAnalises", analiseService.listarAnalisesPorFilme(id));
        return "atualizar";
    }
}

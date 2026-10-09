package com.senac.casafilmes.controller;
import com.senac.casafilmes.service.AnaliseService;
import com.senac.casafilmes.service.FilmeService;
import com.senac.casafilmes.model.Analise;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class AnaliseController {
    
    @Autowired 
    private AnaliseService analiseService;

    @GetMapping("/criarAnaliseForm/{filmeId}")
    public String criarAnaliseForm(@PathVariable("filmeId") Integer filmeId, Model model){
        Analise analise = new Analise();
        model.addAttribute("analiseObj", analise);
        model.addAttribute("filmeId", filmeId);
        return "form_analise";
    }

    @PostMapping("/salvarAnalise/{filmeId}")
    public String salvarAnalise(@PathVariable("filmeId") Integer filmeId, @ModelAttribute("analiseObj") Analise analise){
        analiseService.criarAnalise(filmeId, analise);
        return "redirect:/atualizarFilmeForm/" + filmeId;
    }

    @GetMapping("/atualizarAnaliseForm/{id}")
    public String atualizarAnaliseForm(@PathVariable("id") Integer id, Model model){
        Analise analise = analiseService.getAnaliseId(id);
        model.addAttribute("analiseObj", analise);
        model.addAttribute("filmeId", analise.getFilme().getId());
        return "form_analise";
    }

    @PostMapping("/editarAnalise/{id}")
    public String editarAnalise(@PathVariable("id") Integer id, @ModelAttribute("analiseObj") Analise analise){
        Analise analiseAtualizada = analiseService.atualizarAnalise(id, analise);
        return "redirect:/atualizarFilmeForm/" + analiseAtualizada.getFilme().getId();
    }

    @GetMapping("/deletarAnalise/{id}")
    public String deletarAnalise(@PathVariable("id") Integer id){
        Analise analise = analiseService.getAnaliseId(id);
        Integer filmeId = analise.getFilme().getId();
        analiseService.deletarAnalise(id);
        return "redirect:/atualizarFilmeForm/" + filmeId;
    }
}

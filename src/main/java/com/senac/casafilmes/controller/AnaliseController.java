package com.senac.casafilmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


@Controller
public class AnaliseController {
    @GetMapping("/cadastrarAnalise/{filmeId}")
    public String cadastrarAnalise(@PathVariable Integer filmeId, Model model){
        model.addAttribute("filmeId", filmeId);
        return "form_analise";
    }

    @GetMapping("/atualizarAnalise/{analiseId}/{filmeId}")
    public String atualizarAnalise(Model model, @PathVariable Integer filmeId, @PathVariable Integer analiseId){
        model.addAttribute("analiseId", analiseId);
        model.addAttribute("filmeId", filmeId);
        return "form_analise";
    }
}

package com.senac.casafilmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


@Controller 
public class FilmeController {
    @GetMapping("/")
    public String viewHomePage(@CookieValue(name = "pref-estilo", defaultValue = "claro") String tema, Model model){
        model.addAttribute("tema", tema);
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(){
        return "inserir";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarFilme(@PathVariable Integer id, Model model){
        model.addAttribute("filmeId", id);
        return "atualizar";
    }
}

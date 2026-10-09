package com.senac.casafilmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class FilmeController {
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(){
        return "inserir";
    }

    @GetMapping("/atualizar")
    public String atualizarFilme(){
        return "atualizar";
    }
}

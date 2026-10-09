package com.senac.casafilmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AnaliseController {
    @GetMapping("/cadastrarAnalise")
    public String cadastrarAnalise(){
        return "form_analise";
    }


}

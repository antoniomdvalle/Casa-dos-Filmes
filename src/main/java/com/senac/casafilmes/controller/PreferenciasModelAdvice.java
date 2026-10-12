package com.senac.casafilmes.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.CookieValue;

@ControllerAdvice
public class PreferenciasModelAdvice {

    @ModelAttribute("tema")
    public String disponibilizaTema(
            @CookieValue(name = "pref-estilo", defaultValue = "claro")
            String tema) {

        if (!tema.equals("claro") && !tema.equals("escuro")) {
            return "claro";
        }

        return tema;
    }
}
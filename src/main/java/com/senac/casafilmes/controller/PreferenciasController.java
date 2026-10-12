package com.senac.casafilmes.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PreferenciasController {

    @GetMapping("/preferencias")
    public String preferencias() {
        return "preferencias";
    }

    @PostMapping("/preferencias")
    public ModelAndView gravaPreferencias(@RequestParam String estilo, HttpServletResponse response) {

        // Aceita somente os temas previstos
        if (!estilo.equals("claro") && !estilo.equals("escuro")) {
            estilo = "claro";
        }

        Cookie cookieTema = new Cookie("pref-estilo", estilo);
        cookieTema.setHttpOnly(true);
        cookieTema.setMaxAge(86400);
        cookieTema.setPath("/");

        response.addCookie(cookieTema);

        return new ModelAndView("redirect:/");
    }
}

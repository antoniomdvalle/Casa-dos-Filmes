package com.senac.casafilmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.casafilmes.model.Analise;
import com.senac.casafilmes.service.AnaliseService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/analise")
public class APIAnaliseController {
    @Autowired 
    AnaliseService analiseService;

    // -------------- GET MAPPING --------------
    @GetMapping("/pesquisar/filme/{filmeId}")
    public ResponseEntity<List<Analise>> getAllAnalises(@PathVariable Integer filmeId){
        return ResponseEntity.ok(analiseService.listarAnalisesPorFilme(filmeId));
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Analise> getAnaliseById(@PathVariable Integer id){
        Analise analise = analiseService.getAnaliseId(id);
        return ResponseEntity.ok(analise);
    } 

    // -------------- POST MAPPING --------------
    @PostMapping("/cadastro/filme/{filmeId}")
    public ResponseEntity<Analise> cadastrarAnalise(@Valid @RequestBody Analise Analise, @PathVariable Integer filmeId){
        Analise novaAnalise = analiseService.criarAnalise(filmeId, Analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }

    // -------------- PUT MAPPING --------------
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Analise> atualizarAnalise(@RequestBody Analise analise, @PathVariable Integer id){
        Analise analiseAtualizada = analiseService.atualizarAnalise(id, analise);
        return ResponseEntity.ok(analiseAtualizada);
    }
 
    // -------------- DELETE MAPPING --------------
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAnalise(@PathVariable Integer id){
        analiseService.deletarAnalise(id);
        return ResponseEntity.ok().build();
    }


}

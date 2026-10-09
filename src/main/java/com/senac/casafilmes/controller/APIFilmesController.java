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

import com.senac.casafilmes.model.Filme;
import com.senac.casafilmes.service.FilmeService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/filme")
public class APIFilmesController {

    @Autowired 
    FilmeService filmeService;

    // -------------- GET MAPPING --------------
    @GetMapping("/listar")
    public ResponseEntity<List<Filme>> getAllFilmes(){
        List<Filme> filmes = filmeService.listAllFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }


    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Integer id){
        Filme filme = filmeService.getFilmeId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    // -------------- POST MAPPING --------------
    @PostMapping("/cadastro")
    public ResponseEntity<Filme> cadastrarFilme(@Valid @RequestBody Filme filme){
        Filme novoFilme = filmeService.criarFilme(filme);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    // -------------- PUT MAPPING --------------
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer id, @RequestBody Filme filme){
        var filmeAtualizado = filmeService.atualizarFilme(id, filme);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }

        // -------------- DELETE MAPPING --------------
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Integer id){
        filmeService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

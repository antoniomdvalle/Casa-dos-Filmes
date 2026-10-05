package com.senac.casafilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.casafilmes.model.Filme;

import com.senac.casafilmes.model.FilmeRepository;


import com.senac.casafilmes.exception.ResourceNotFoundException;

@Service 
public class FilmeService {

    @Autowired 
    FilmeRepository filmeRepository;


    public Filme criarFilme(Filme f){
        f.setId(null);
        filmeRepository.save(f);
        return f;
    }


    public Filme atualizarFilme(Integer filmeId, Filme filmeRequisicao){
        Filme filme = getFilmeId(filmeId);

        filme.setTitulo(filmeRequisicao.getTitulo());
        filme.setSinopse(filmeRequisicao.getSinopse());
        filme.setGenero(filmeRequisicao.getGenero());
        filme.setAnoLancamento(filmeRequisicao.getAnoLancamento());
        
        return filmeRepository.save(filme);
    }


    public Filme getFilmeId(Integer filmeId){
        return filmeRepository.findById(filmeId).orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado."));
    }


    public List<Filme> listAllFilmes(){
        return filmeRepository.findAll();
    }


    public void deletarFilme(Integer filmeId){
        Filme f = getFilmeId(filmeId);
        filmeRepository.deleteById(f.getId());
    }
}

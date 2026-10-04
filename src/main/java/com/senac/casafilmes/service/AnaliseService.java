package com.senac.casafilmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.casafilmes.model.Analise;
import com.senac.casafilmes.model.Filme;
import com.senac.casafilmes.model.FilmeRepository;

import com.senac.casafilmes.model.AnaliseRepository;

@Service 
public class AnaliseService {
    @Autowired 
    AnaliseRepository analiseRepository;
    @Autowired 
    FilmeRepository filmeRepository;

    public Analise criarAnalise(Integer filmeId, Analise a){
        Filme filme = filmeRepository.findById(filmeId).orElseThrow(() -> new RuntimeException("Filme não encontrado."));
        a.setFilme(filme);
        return analiseRepository.save(a);
    }

    public Analise atualizarAnalise(Integer idAnalise, Analise analiseRequisicao){
        Analise analise = getAnaliseId(idAnalise);

        analise.setFilme(analiseRequisicao.getFilme());
        analise.setNota(analiseRequisicao.getNota());
        analise.setAnalise(analiseRequisicao.getAnalise());

        analiseRepository.save(analise);

        return analise;
    }

    public List<Analise> listarAnalisesPorFilme(Integer filmeId){
        return analiseRepository.findByFilmeId(filmeId);
    }

    public Analise getAnaliseId(Integer idAnalise){
        return analiseRepository.findById(idAnalise).orElse(null);
    }

    public List<Analise> listarAnalises(){
        return analiseRepository.findAll();
    }

    public void deletarAnalise(Integer idAnalise){
        Analise a = getAnaliseId(idAnalise);
        analiseRepository.deleteById(a.getId());
    }
}

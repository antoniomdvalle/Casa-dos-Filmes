package com.senac.casafilmes.model;

public class Analise {
    private int id;
    private Filme filme;
    private String analise;
    private double nota;

    public Analise(){}

    public Analise(int id, Filme filme, String analise, double nota){
        this.id = id;
        this.filme = filme;
        this.analise = analise;
        this.nota = nota;
    }

    // Getters e Setters para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters e Setters para filme
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    // Getters e Setters para analise
    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    // Getters e Setters para nota
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
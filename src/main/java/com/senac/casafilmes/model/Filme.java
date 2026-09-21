package com.senac.casafilmes.model;

public class Filme {
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int anoLancamento;

    public Filme() {}

    public Filme (int id, String titulo, String sinopse, String genero, int anoLancamento){
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    // Getters e Setters para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters e Setters para titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getters e Setters para sinopse
    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    // Getters e Setters para genero
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getters e Setters para anoLancamento
    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
package com.senac.casafilmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity 
@Table(name="Filme")
public class Filme {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int anoLancamento;
}
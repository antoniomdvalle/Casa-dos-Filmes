package com.senac.casafilmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity 
@Table(name="Analise")
public class Analise {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private Filme filme;
    private String analise;
    private double nota;
}
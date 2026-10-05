package com.senac.casafilmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data 
@Entity 
@Table(name="Analise")
public class Analise {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Por favor, digite o filme dessa análise.")
    @ManyToOne 
    @JoinColumn(name="filme_id")
    private Filme filme;
    
    @NotBlank(message = "Favor digitar uma análise.")
    private String analise;

    @NotNull(message = "Informe uma nota.")
    private Double nota;
}
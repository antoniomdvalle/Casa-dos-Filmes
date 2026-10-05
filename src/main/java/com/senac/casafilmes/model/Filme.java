package com.senac.casafilmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity 
@Table(name="Filme")
public class Filme {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=2, message = "Por favor, insira um título.")
    private String titulo;

    @NotBlank(message = "Favor detalhar a sinopse para este filme.")
    private String sinopse;

    @NotBlank(message = "Favor inserir o gênero mais apropriado a este filme.")
    private String genero;

    @NotNull(message = "Favor informar o ano de lançamento.")
    private int anoLancamento;
}
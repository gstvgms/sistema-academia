package br.com.projeto.sistema_academia.dto;

import lombok.Data;

@Data
public class ExercicioDTO {
    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;
    private double carga;
    private String observacoes;
}

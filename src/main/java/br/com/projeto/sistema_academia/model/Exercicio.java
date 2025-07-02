package br.com.projeto.sistema_academia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String grupoMuscular;
    private int series;
    private int repeticoes;
    private double carga;
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id")
    @JsonIgnore
    private Treino treino; // Relacionamento com a entidade Treino, indicando que um exercício pertence a um treino específico
}

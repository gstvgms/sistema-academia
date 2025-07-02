package br.com.projeto.sistema_academia.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TreinoRequestDTO {
    private Long alunoId;
    private Long professorId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<ExercicioDTO> exercicios;
}

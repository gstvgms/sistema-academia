package br.com.projeto.sistema_academia.dto;

import br.com.projeto.sistema_academia.model.Treino;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TreinoResponseDTO {
    private Long id;
    private String nomeAluno;
    private String nomeProfessor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<ExercicioDTO> exercicios;

    public TreinoResponseDTO(Treino treino) {
        this.id = treino.getId();
        this.nomeAluno = treino.getAluno().getNome();
        this.nomeProfessor = treino.getProfessor().getNome();
        this.dataInicio = treino.getDataInicio();
        this.dataFim = treino.getDataFim();
        this.exercicios = treino.getExercicios().stream().map(ex -> {
            ExercicioDTO dto = new ExercicioDTO();
            dto.setNome(ex.getNome());
            dto.setGrupoMuscular(ex.getGrupoMuscular());
            dto.setSeries(ex.getSeries());
            dto.setRepeticoes(ex.getRepeticoes());
            dto.setCarga(ex.getCarga());
            dto.setObservacoes(ex.getObservacoes());
            return dto;
        }).collect(Collectors.toList());
    }
}

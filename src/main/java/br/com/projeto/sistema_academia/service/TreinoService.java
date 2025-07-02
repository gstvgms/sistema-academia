package br.com.projeto.sistema_academia.service;

import br.com.projeto.sistema_academia.dto.TreinoRequestDTO;
import br.com.projeto.sistema_academia.dto.TreinoResponseDTO;
import br.com.projeto.sistema_academia.model.*;
import br.com.projeto.sistema_academia.repository.AlunoRepository;
import br.com.projeto.sistema_academia.repository.ProfessorRepository;
import br.com.projeto.sistema_academia.repository.TreinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional
    public Treino criarTreino(TreinoRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Treino treino = new Treino();
        treino.setAluno(aluno);
        treino.setProfessor(professor);
        treino.setDataInicio(dto.getDataInicio());
        treino.setDataFim(dto.getDataFim());

        List<Exercicio> listaExercicios = dto.getExercicios().stream().map(exDeto -> {
            Exercicio exercicio = new Exercicio();
            exercicio.setNome(exDeto.getNome());
            exercicio.setGrupoMuscular(exDeto.getGrupoMuscular());
            exercicio.setSeries(exDeto.getSeries());
            exercicio.setRepeticoes(exDeto.getRepeticoes());
            exercicio.setCarga(exDeto.getCarga());
            exercicio.setObservacoes(exDeto.getObservacoes());
            exercicio.setTreino(treino);
            return exercicio;
        }).collect(Collectors.toList());

        treino.setExercicios(listaExercicios);

        return treinoRepository.save(treino);
    }

    public List<TreinoResponseDTO> listarTodos() {
        return treinoRepository.findAll()
                .stream()
                .map(TreinoResponseDTO::new)
                .collect(Collectors.toList());
    }
}

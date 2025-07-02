package br.com.projeto.sistema_academia.controller;

import br.com.projeto.sistema_academia.dto.TreinoRequestDTO;
import br.com.projeto.sistema_academia.dto.TreinoResponseDTO;
import br.com.projeto.sistema_academia.model.Aluno;
import br.com.projeto.sistema_academia.model.Professor;
import br.com.projeto.sistema_academia.model.Treino;
import br.com.projeto.sistema_academia.repository.AlunoRepository;
import br.com.projeto.sistema_academia.repository.ProfessorRepository;
import br.com.projeto.sistema_academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TreinoController {
    @Autowired
    private TreinoService treinoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/alunos")
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/professores")
    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/treinos")
    public List<TreinoResponseDTO> getTreinos() {
        return treinoService.listarTodos();
    }

    @PostMapping("/treinos")
    public ResponseEntity<Treino> criarTreino(@RequestBody TreinoRequestDTO dto) {
        try {
            Treino novoTreino = treinoService.criarTreino(dto);
            return ResponseEntity.ok(novoTreino);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

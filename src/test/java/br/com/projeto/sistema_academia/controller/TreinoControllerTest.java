package br.com.projeto.sistema_academia.controller;

import br.com.projeto.sistema_academia.model.Aluno;
import br.com.projeto.sistema_academia.model.Professor;
import br.com.projeto.sistema_academia.repository.AlunoRepository;
import br.com.projeto.sistema_academia.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TreinoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    void setup() {
        alunoRepository.deleteAll();
        professorRepository.deleteAll();

        Aluno aluno = new Aluno();
        aluno.setNome("Aluno para Realizar Teste Funcional");
        alunoRepository.save(aluno);
    }

    @Test
    void deveRetornarStatus200EListarAlunos() throws Exception {
        // Testa a funcionalidade de listar alunos
        mockMvc.perform(get("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nome").value("Aluno Para Teste Funcional"));
    }
}
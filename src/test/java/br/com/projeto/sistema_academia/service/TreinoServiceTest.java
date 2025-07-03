package br.com.projeto.sistema_academia.service;

import br.com.projeto.sistema_academia.dto.ExercicioDTO;
import br.com.projeto.sistema_academia.dto.TreinoRequestDTO;
import br.com.projeto.sistema_academia.model.Aluno;
import br.com.projeto.sistema_academia.model.Professor;
import br.com.projeto.sistema_academia.model.Treino;
import br.com.projeto.sistema_academia.repository.AlunoRepository;
import br.com.projeto.sistema_academia.repository.ProfessorRepository;
import br.com.projeto.sistema_academia.repository.TreinoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TreinoServiceTest {
    @Mock
    private TreinoRepository treinoRepository;
    @Mock
    private AlunoRepository alunoRepository;
    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private TreinoService treinoService;

    @Test
    void deveCriarUmTreino() {
        TreinoRequestDTO dto = new TreinoRequestDTO();
        dto.setAlunoId(1L);
        dto.setProfessorId(1L);
        dto.setDataInicio(LocalDate.now());
        dto.setExercicios(Collections.singletonList(new ExercicioDTO()));

        Aluno alunoMock = new Aluno();
        alunoMock.setId(1L);
        alunoMock.setNome("Aluno somente Para Testes");

        Professor profMock = new Professor();
        profMock.setId(1L);

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(alunoMock));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(profMock));
        when(treinoRepository.save(any(Treino.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Treino treinoCriado = treinoService.criarTreino(dto);

        assertNotNull(treinoCriado);
        assertEquals("Aluno somente Para Testes", treinoCriado.getAluno().getNome());
        assertEquals(1, treinoCriado.getExercicios().size());
    }
}

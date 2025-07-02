package br.com.projeto.sistema_academia;

import br.com.projeto.sistema_academia.model.Aluno;
import br.com.projeto.sistema_academia.model.Professor;
import br.com.projeto.sistema_academia.repository.AlunoRepository;
import br.com.projeto.sistema_academia.repository.ProfessorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemaAcademiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademiaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(AlunoRepository alunoRepo, ProfessorRepository profRepo) {
		return args -> {
			System.out.println("Populando o banco de dados com dados iniciais...");

			Aluno a1 = new Aluno();
			a1.setNome("Gustavo Gomes");
			alunoRepo.save(a1);

			Aluno a2 = new Aluno();
			a2.setNome("Luigi Veriano");
			alunoRepo.save(a2);

			Aluno a3 = new Aluno();
			a3.setNome("Alvaro Peringer");
			alunoRepo.save(a3);

			Professor p1 = new Professor();
			p1.setNome("Mauricio");
			p1.setCref("123456-G/PR");
			profRepo.save(p1);

			System.out.println("Dados iniciais inseridos com sucesso!");
		};
	}

}

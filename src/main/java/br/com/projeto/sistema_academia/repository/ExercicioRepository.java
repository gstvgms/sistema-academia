package br.com.projeto.sistema_academia.repository;

import br.com.projeto.sistema_academia.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
}

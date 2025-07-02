package br.com.projeto.sistema_academia.repository;

import br.com.projeto.sistema_academia.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    // Aqui você pode adicionar métodos personalizados se necessário
}

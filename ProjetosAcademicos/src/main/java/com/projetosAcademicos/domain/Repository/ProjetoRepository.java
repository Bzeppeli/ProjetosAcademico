package com.projetosAcademicos.domain.Repository;

import com.projetosAcademicos.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}

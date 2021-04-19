package br.edu.ifma.si.lpw.imobiliaria.repository;

import br.edu.ifma.si.lpw.imobiliaria.model.Inquilino;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Integer> {
    Page<Inquilino> findByNomeContaining(String nome, Pageable paginacao);
}

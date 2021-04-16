package br.edu.ifma.si.lpw.imobiliaria.repository;

import br.edu.ifma.si.lpw.imobiliaria.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {
}

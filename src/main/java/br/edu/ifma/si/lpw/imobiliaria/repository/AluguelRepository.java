package br.edu.ifma.si.lpw.imobiliaria.repository;

import br.edu.ifma.si.lpw.imobiliaria.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
}

package br.edu.ifma.si.lpw.imobiliaria.repository;

import br.edu.ifma.si.lpw.imobiliaria.model.Imovel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
    Page<Imovel> findByEnderecoContaining(String endereco, Pageable paginacao);
}

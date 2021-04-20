package br.edu.ifma.si.lpw.imobiliaria.repository.imovel;

import br.edu.ifma.si.lpw.imobiliaria.model.Imovel;
import br.edu.ifma.si.lpw.imobiliaria.repository.filter.ImovelFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImovelRepositoryQuery {
    Page<Imovel> filtra(ImovelFilter imovelFiltro, Pageable paginacao);
}

package br.edu.ifma.si.lpw.imobiliaria.repository.imovel;

import br.edu.ifma.si.lpw.imobiliaria.model.Imovel;
import br.edu.ifma.si.lpw.imobiliaria.repository.filter.ImovelFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImovelRepositoryImplement implements ImovelRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Imovel> filtra(ImovelFilter imovelFiltro, Pageable paginacao) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();

        CriteriaQuery<Imovel> imovelCriteriaQuery = criteriaBuilder.createQuery(Imovel.class);

        Root<Imovel> imovelRoot = imovelCriteriaQuery.from(Imovel.class);

        Predicate[] restricoes = this.criaRestricoes(imovelFiltro, criteriaBuilder, imovelRoot);

        imovelCriteriaQuery.select(imovelRoot).where(restricoes).orderBy(criteriaBuilder.asc(imovelRoot.get("endereco")));

        TypedQuery<Imovel> imovelTypedQuery = manager.createQuery(imovelCriteriaQuery);
        adicionaRestricoesDePaginacao(imovelTypedQuery, paginacao);

        return new PageImpl<>(imovelTypedQuery.getResultList(), paginacao, total(imovelFiltro));
    }

    private Predicate[] criaRestricoes(ImovelFilter imovelFiltro, CriteriaBuilder criteriaBuilder, Root<Imovel> imovelRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if (imovelFiltro.getEndereco() != null && !(imovelFiltro.getEndereco().isEmpty())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(imovelRoot.get("endereco")), "%" + imovelFiltro.getEndereco().toLowerCase() + "%"));
        }
        if (Objects.nonNull(imovelFiltro.getValorDe()) ) {
            predicates.add(criteriaBuilder.ge(imovelRoot.get("valor_sugerido"), imovelFiltro.getValorDe()));
        }
        if(Objects.nonNull(imovelFiltro.getValorAte())) {
            predicates.add(criteriaBuilder.le(imovelRoot.get("valor_sugerido"), imovelFiltro.getValorAte()));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionaRestricoesDePaginacao(TypedQuery<Imovel> imovelTypedQuery, Pageable paginacao) {
        Integer paginaAtual = paginacao.getPageNumber();
        Integer totalDeObjetosPorPagina = paginacao.getPageSize();
        Integer primeiroObjetoDaPagina = paginaAtual * totalDeObjetosPorPagina;

        imovelTypedQuery.setFirstResult(primeiroObjetoDaPagina);
        imovelTypedQuery.setMaxResults(totalDeObjetosPorPagina);
    }

    private Long total(ImovelFilter imovelFiltro) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

        Root<Imovel> imovelRoot = criteriaQuery.from(Imovel.class);

        Predicate[] predicates = criaRestricoes(imovelFiltro, criteriaBuilder, imovelRoot);

        criteriaQuery.where(predicates);
        criteriaQuery.select(criteriaBuilder.count(imovelRoot));

        return manager.createQuery(criteriaQuery).getSingleResult();
    }
}

package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Locacao {
    private Integer id;
    private Imovel imovel;
    private Cliente inquilino;
    private boolean ativo;
    private LocalDate inicioDonContrato;
    private LocalDate fimDonContrato;
    private Integer diaDoVencimento;
    private BigDecimal percentualDaMulta;
    private BigDecimal valorDoAluguel;
    private String observacoes;

    public Locacao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    @ManyToOne
    public Cliente getInquilino() {
        return inquilino;
    }

    public void setInquilino(Cliente inquilino) {
        this.inquilino = inquilino;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getInicioDonContrato() {
        return inicioDonContrato;
    }

    public void setInicioDonContrato(LocalDate inicioDonContrato) {
        this.inicioDonContrato = inicioDonContrato;
    }

    public LocalDate getFimDonContrato() {
        return fimDonContrato;
    }

    public void setFimDonContrato(LocalDate fimDonContrato) {
        this.fimDonContrato = fimDonContrato;
    }

    public Integer getDiaDoVencimento() {
        return diaDoVencimento;
    }

    public void setDiaDoVencimento(Integer diaDoVencimento) {
        this.diaDoVencimento = diaDoVencimento;
    }

    public BigDecimal getPercentualDaMulta() {
        return percentualDaMulta;
    }

    public void setPercentualDaMulta(BigDecimal percentualDaMulta) {
        this.percentualDaMulta = percentualDaMulta;
    }

    public BigDecimal getValorDoAluguel() {
        return valorDoAluguel;
    }

    public void setValorDoAluguel(BigDecimal valorDoAluguel) {
        this.valorDoAluguel = valorDoAluguel;
    }

    @Length(max = 200)
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

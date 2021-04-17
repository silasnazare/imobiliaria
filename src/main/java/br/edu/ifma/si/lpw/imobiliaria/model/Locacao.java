package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Imovel imovel;
    @ManyToOne
    private Cliente inquilino;
    private boolean ativo;
    private LocalDate inicioDonContrato;
    private LocalDate fimDonContrato;
    @Positive
    @Max(31)
    private Integer diaDoVencimento;
    private BigDecimal percentualDaMulta;
    private BigDecimal valorDoAluguel;
    @Length(max = 200)
    private String observacoes;

    public Locacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

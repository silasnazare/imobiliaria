package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Null;
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
    private Cliente cliente;
    private boolean ativo;
    private LocalDate inicioDoContrato;
    private LocalDate fimDoContrato;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getInicioDoContrato() {
        return inicioDoContrato;
    }

    public void setInicioDoContrato(LocalDate inicioDoContrato) {
        this.inicioDoContrato = inicioDoContrato;
    }

    public LocalDate getFimDoContrato() {
        return fimDoContrato;
    }

    public void setFimDoContrato(LocalDate fimDoContrato) {
        this.fimDoContrato = fimDoContrato;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifma.si.lpw.imobiliaria.model.Locacao[ id=" + id + " ]";
    }
}

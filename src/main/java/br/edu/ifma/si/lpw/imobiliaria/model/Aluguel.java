package br.edu.ifma.si.lpw.imobiliaria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Aluguel {
    private Integer id;
    private Locacao locacao;
    private LocalDate dataDoVencimento;
    private BigDecimal valorPago;
    private String observacoes;

    public Aluguel() {
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
    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public LocalDate getDataDoVencimento() {
        return dataDoVencimento;
    }

    public void setDataDoVencimento(LocalDate dataDoVencimento) {
        this.dataDoVencimento = dataDoVencimento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

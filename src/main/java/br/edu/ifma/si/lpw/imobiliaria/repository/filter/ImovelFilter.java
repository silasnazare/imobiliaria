package br.edu.ifma.si.lpw.imobiliaria.repository.filter;

import java.math.BigDecimal;

public class ImovelFilter {
    private String Endereco;
    private BigDecimal valorDe;
    private BigDecimal valorAte;

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public BigDecimal getValorDe() {
        return valorDe;
    }

    public void setValorDe(BigDecimal valorDe) {
        this.valorDe = valorDe;
    }

    public BigDecimal getValorAte() {
        return valorAte;
    }

    public void setValorAte(BigDecimal valorAte) {
        this.valorAte = valorAte;
    }
}

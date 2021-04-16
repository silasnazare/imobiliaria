package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Imovel {
    private Integer id;
    private String tipoDeImovel;
    private String endereco;
    private Integer dormitorios;
    private Integer banheiros;
    private Integer suites;
    private BigDecimal metragem;
    private BigDecimal valorSugerido;
    private String observacoes;

    public Imovel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Length(max = 20)
    public String getTipoDeImovel() {
        return tipoDeImovel;
    }

    public void setTipoDeImovel(String tipoDeImovel) {
        this.tipoDeImovel = tipoDeImovel;
    }

    @Length(max = 200)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public BigDecimal getMetragem() {
        return metragem;
    }

    public void setMetragem(BigDecimal metragem) {
        this.metragem = metragem;
    }

    public BigDecimal getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(BigDecimal valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    @Length(max = 200)
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

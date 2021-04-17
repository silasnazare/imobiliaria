package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Imovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 20)
    private String tipoDeImovel;
    @Length(max = 100)
    private String endereco;
    @Positive
    private Integer dormitorios;
    @Positive
    private Integer banheiros;
    @Positive
    private Integer suites;
    private BigDecimal metragem;
    private BigDecimal valorSugerido;
    @Length(max = 200)
    private String observacoes;

    public Imovel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDeImovel() {
        return tipoDeImovel;
    }

    public void setTipoDeImovel(String tipoDeImovel) {
        this.tipoDeImovel = tipoDeImovel;
    }

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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

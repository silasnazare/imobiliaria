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
    private Integer quantidadeDeDormitorios;
    @Positive
    private Integer quantidadeDeBanheiros;
    @Positive
    private Integer quantidadeDeSuites;
    private Integer metragem;
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

    public Integer getQuantidadeDeDormitorios() {
        return quantidadeDeDormitorios;
    }

    public void setQuantidadeDeDormitorios(Integer quantidadeDeDormitorios) {
        this.quantidadeDeDormitorios = quantidadeDeDormitorios;
    }

    public Integer getQuantidadeDeBanheiros() {
        return quantidadeDeBanheiros;
    }

    public void setQuantidadeDeBanheiros(Integer quantidadeDeBanheiros) {
        this.quantidadeDeBanheiros = quantidadeDeBanheiros;
    }

    public Integer getQuantidadeDeSuites() {
        return quantidadeDeSuites;
    }

    public void setQuantidadeDeSuites(Integer quantidadeDeSuites) {
        this.quantidadeDeSuites = quantidadeDeSuites;
    }

    public Integer getMetragem() {
        return metragem;
    }

    public void setMetragem(Integer metragem) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imovel)) {
            return false;
        }
        Imovel other = (Imovel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifma.si.lpw.imobiliaria.model.Imovel[ id=" + id + " ]";
    }
}

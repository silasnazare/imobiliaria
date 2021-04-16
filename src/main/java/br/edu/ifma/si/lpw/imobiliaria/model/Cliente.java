package br.edu.ifma.si.lpw.imobiliaria.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;

    public Cliente() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull @NotEmpty @Length(min = 3, max = 200)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Length(max = 11)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Length(min = 8)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}

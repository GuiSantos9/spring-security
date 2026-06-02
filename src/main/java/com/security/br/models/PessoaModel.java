package com.security.br.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity // cria uma entidade (tabela) no banco de dados
public class PessoaModel {

    @Id // cria um marcador único para cada entidade no banco de dados (id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // faz com que não precisemos colocar cada id para cada entidades
    private Long id;
    private String nome;
    private Integer idade;

    // relacionamento entre PessoaModel e JobModel
    @OneToMany(fetch = FetchType.EAGER)
    private List<JobModel> jobModelList = new ArrayList<>();

    public PessoaModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

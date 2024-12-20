package com.doceria.api.model;

import com.doceria.api.dto.DoceriaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@Entity
@Table(name="doces")
public class DoceriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private Long version;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private double valor;

    private String descricao;

    @NotBlank
    private String imgUrl;

    // Construtor sem argumentos (default)
    public DoceriaModel() {
    }

    public DoceriaModel(DoceriaDto dto){
        this.nome = dto.nome();
        this.valor = dto.valor();
        this.descricao = dto.descricao();
        this.imgUrl = dto.imgUrl();
    }

    // Construtor que inicializa todos os atributos
    public DoceriaModel(UUID id, String nome, double valor, String descricao, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
    }

    public UUID getId() {return id;}

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

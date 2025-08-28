package com.magnumbank.api1.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String marca;
    private String modelo;

    @Column(length = 1000)
    private String observacoes;

    public Veiculo() {}

    public Veiculo(String codigo, String marca, String modelo) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo veiculo)) return false;
        return Objects.equals(getId(), veiculo.getId()) && Objects.equals(getCodigo(), veiculo.getCodigo()) && Objects.equals(getMarca(), veiculo.getMarca()) && Objects.equals(getModelo(), veiculo.getModelo()) && Objects.equals(getObservacoes(), veiculo.getObservacoes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo(), getMarca(), getModelo(), getObservacoes());
    }
}

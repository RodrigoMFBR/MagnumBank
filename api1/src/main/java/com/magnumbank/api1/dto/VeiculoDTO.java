package com.magnumbank.api1.dto;

public class VeiculoDTO{
    private String codigo;
    private String marca;
    private String modelo;
    private String observacoes;

    public VeiculoDTO(String codigo, String modelo, String observacoes) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.observacoes = observacoes;
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
}


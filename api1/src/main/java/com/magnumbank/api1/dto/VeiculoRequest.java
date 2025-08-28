package com.magnumbank.api1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VeiculoRequest {

    @NotBlank(message = "O modelo não pode estar em branco")
    @Size(max =255, message = "O campo modelo suporta até 255 caracteres")
    private String modelo;

    @Size(max =1000, message = "O campo modelo suporta até 255 caracteres")
    private String observacoes;

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

package com.magnumbank.api2.queue;


import java.io.Serializable;

public class MarcaMessage implements Serializable {
    private String codigo;
    private String nome;

    public MarcaMessage() {}

    public MarcaMessage(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNome(String nome) { this.nome = nome; }
}

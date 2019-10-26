package br.com.aceleradev.domain;

import java.util.Objects;

public class Pessoa {

    private long id;
    private double altura;
    private String nome, sobrenome;


    public Pessoa(long id, String nome){
        this.id=id;
        this.nome=nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id && nome==pessoa.getNome();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, altura);
    }
}

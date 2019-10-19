package br.com.aceleradev.domain;

import br.com.aceleradev.exceptions.NumeroMaximoDeAlunosException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Disciplina {

    public enum Tipo {
        HUMANAS, BIOLOGICAS, EXATAS
    }

    private String nome;
    private Tipo tipo;
    private List<Aluno> alunos = new ArrayList<>();

    private Professor professor;

    public Disciplina(String nome, Professor professor, Tipo tipo) {
        this.nome = nome;
        this.professor = professor;
        this.tipo = tipo;
    }

    public void matricular(Aluno aluno) {
        if(alunos.size() == 10){
            throw new NumeroMaximoDeAlunosException("Disciplina lotada");
        }
        alunos.add(aluno);
    }

    public void mostraAlunos() {
        alunos.forEach(System.out::println);

//        alunos.forEach(aluno -> {
//            System.out.println(aluno);
//        });
//
//        alunos.forEach(aluno -> System.out.println(aluno));
//
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                ", professor=" + professor +
                "\n";
    }
}

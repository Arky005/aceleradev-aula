package br.com.aceleradev.domain;

import java.util.List;

public class Professor extends Usuario {

    private List<Disciplina> disciplinas;
    public Professor(String nome, String login, String cpf) {

        super(nome, login, cpf, null);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina d){

    }
}

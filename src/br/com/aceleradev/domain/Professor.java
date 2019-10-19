package br.com.aceleradev.domain;

import java.util.List;

public class Professor extends Usuario {

    private List<Disciplina> disciplinas;
    private int anoInicioCarreira;
    public Professor(String nome, String login, String cpf, int anoInicioCarreira) {

        super(nome, login, cpf, null);
        this.anoInicioCarreira=anoInicioCarreira;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina d){

    }

    public int getAnoInicioCarreira() {
        return anoInicioCarreira;
    }
}

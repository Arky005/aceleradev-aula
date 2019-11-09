package br.com.aceleradev.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "professor")
public class Professor extends UsuarioAutorizavel {

    @OneToMany(mappedBy = "professor")
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

    /*
    @Override
    public boolean temAutorizacao() {
        return true;
    }*/

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("PROF");
    }
}

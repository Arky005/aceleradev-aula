package br.com.aceleradev.utils;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;
import br.com.aceleradev.domain.Professor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class DataLoader {

    private DataLoader(){};

    public static void popularDeAlunos(List<Aluno> lista){
        Aluno aluno;
        LocalDate data = LocalDate.of(1990, Month.DECEMBER, 21) ;
        for(int i=0; i<5; i++) {
            aluno = new Aluno(
                    "Gustavo "+i,
                    "gustavo",
                    "123.456.789-12", data);
            lista.add(aluno);
        }
    }

    public static void popularDeProfessores(List<Professor> lista){

        for(int i=0; i<5; i++) {
            lista.add(new Professor(
                    "Lucas Pacheco "+i, "lucas123", "132.132.132.90"));
        }
    }

    public static void popularDeDisciplinas(List<Disciplina> listaDisc)
    {
        List<Professor> profs = new ArrayList<>();
        Disciplina.Tipo tipo;
        popularDeProfessores(profs);
        for(int i=0; i<5; i++){
            if(i==0) tipo=Disciplina.Tipo.EXATAS;
            else if(i%2==0) tipo= Disciplina.Tipo.HUMANAS;
            else tipo= Disciplina.Tipo.BIOLOGICAS;

            listaDisc.add(new Disciplina("disciplina "+i, profs.get(i), tipo));
        }
    }
    
    public static void matricularAlunos(List<Disciplina> listaDisc){

        List<Aluno> listaAlunos = new ArrayList<>();
        popularDeAlunos(listaAlunos);
        for(int i=0; i<listaDisc.size(); i++){
                listaDisc.get(i).matricular(listaAlunos.get(i));
        }
    }


}

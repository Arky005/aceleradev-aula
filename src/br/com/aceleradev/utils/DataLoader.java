package br.com.aceleradev.utils;

import br.com.aceleradev.domain.Aluno;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DataLoader {

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

}

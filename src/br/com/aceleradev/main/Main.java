package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Aluno> lista = new ArrayList<>();
    public static void main(String[] args) {

        Aluno aluno;
        LocalDate data = LocalDate.of(1990, Month.DECEMBER, 21) ;
        for(int i=0; i<5; i++) {
            aluno = new Aluno(
                    "Gustavo "+i,
                    "gustavo",
                    "123.456.789-12", data);
            ;

            lista.add(aluno);
        }

        getMediaIdade();
//        System.out.println(aluno);

    }

    public static int getMediaIdade(){

        int idades=0;
        LocalDate dataAtual = LocalDate.now();

        for(int i=0; i<lista.size(); i++){
            idades+=dataAtual.getYear()-lista.get(i).getDataNascimento().getYear();
        }
        return idades/lista.size();
    }

}

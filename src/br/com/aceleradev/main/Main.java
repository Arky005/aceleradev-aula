package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.utils.DataLoader;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Aluno> lista = new ArrayList<>();
    public static void main(String[] args) {

        DataLoader.popularDeAlunos(lista);
        System.out.println(getMediaIdade());

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

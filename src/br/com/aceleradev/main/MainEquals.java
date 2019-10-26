package br.com.aceleradev.main;

import br.com.aceleradev.domain.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainEquals {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        //Set<Pessoa> pessoas = new HashSet<>(); //nao adiciona iguais

        Pessoa pessoa1 = new Pessoa(1l,"Joao");
        Pessoa pessoa2 = new Pessoa(2l, "Lucas");
        Pessoa pessoa3 = new Pessoa(3l, "Denis");

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        Pessoa pessoaProcurar = new Pessoa(1l, "Marcos");

        //o contains executa o equals pra cada item
        System.out.println(pessoas.contains(pessoaProcurar));
        System.out.println(pessoa1.equals(pessoaProcurar));

        System.out.println(pessoa1.hashCode());
        System.out.println(pessoaProcurar.hashCode());
        System.out.println(pessoa1.hashCode() == pessoaProcurar.hashCode());


    }

}

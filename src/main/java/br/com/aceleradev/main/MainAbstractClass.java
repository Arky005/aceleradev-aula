package br.com.aceleradev.main;

import br.com.aceleradev.domain.Coordernador;
import br.com.aceleradev.domain.Diretor;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.services.LancadorNotas;

public class MainAbstractClass {

    public static void main(String[] args) {
        Coordernador coordernador = new Coordernador(1l, "Joao", "joao123", "", null);
        Professor professor = new Professor("Batata", "batata123", "", 0);
        Diretor diretor = new Diretor("Diretor", "diretor123", "", null);


        new LancadorNotas().login(coordernador);
        
    }

}

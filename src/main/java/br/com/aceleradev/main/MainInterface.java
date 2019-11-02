package br.com.aceleradev.main;

import br.com.aceleradev.domain.Coordernador;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.services.LancadorNotas;

public class MainInterface {

    public static void main(String[] args) {

        Coordernador coordernador = new Coordernador(1l, "Joao", "joao123", "", null);
        Professor professor = new Professor("Batata", "batata123", "", 0);

        LancadorNotas lancadorNotas = new LancadorNotas();
        //lancadorNotas.login(coordernador);
        //lancadorNotas.login(professor);
    }
}

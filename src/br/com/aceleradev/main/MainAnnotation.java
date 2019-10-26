package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Usuario;
import br.com.aceleradev.services.GeradorDeRelatorio;

import java.util.ArrayList;
import java.util.List;

public class MainAnnotation {

    public static void main(String[] args) {
        GeradorDeRelatorio gerador = new GeradorDeRelatorio();
        Usuario usuario = new Aluno("Joao", "joao123", "", null);
        List<Object> usuarios = new ArrayList<>();

        usuarios.add(usuario);
        gerador.gerarRelatorio(usuarios, 2);

    }
}

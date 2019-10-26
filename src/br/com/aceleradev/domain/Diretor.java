package br.com.aceleradev.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Diretor extends UsuarioAutorizavel {


    public Diretor(String nome, String login, String cpf, LocalDate nascimento) {
        super(nome, login, cpf, nascimento);
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("ADMIN");
    }
}

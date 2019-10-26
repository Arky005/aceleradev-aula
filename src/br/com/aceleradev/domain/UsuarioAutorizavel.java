package br.com.aceleradev.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioAutorizavel extends  Usuario{


    public UsuarioAutorizavel(String nome, String login, String cpf, LocalDate nascimento) {
        super(nome, login, cpf, nascimento);
    }

    public boolean temAutorizacao(){
        List<String> autorizacoes = getAutorizacao();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    }

    protected abstract boolean verificarAutorizacaoLogin();

    protected abstract List<String> getAutorizacao();

}

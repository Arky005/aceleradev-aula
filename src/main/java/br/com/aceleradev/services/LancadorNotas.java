package br.com.aceleradev.services;

import br.com.aceleradev.domain.Usuario;
import br.com.aceleradev.domain.UsuarioAutorizavel;
import br.com.aceleradev.exceptions.UsuarioSemAutorizacaoException;

public class LancadorNotas {

    public void login(UsuarioAutorizavel user){
        if(!user.temAutorizacao())
            throw new UsuarioSemAutorizacaoException("Usuário não tem autorizacao");

        System.out.println("Notas lançadas");
    }


}

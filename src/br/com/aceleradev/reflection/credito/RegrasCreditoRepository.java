package br.com.aceleradev.reflection.credito;

import br.com.aceleradev.reflection.enums.RegraValor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegrasCreditoRepository {


    public List<RegraCredito> findAllRegras(){

        RegraCredito regra1 = new RegraCredito();
        regra1.setNome("scoreSerasa");
        regra1.setReferencia("scoreSerasa");
        regra1.setValorReferencia(500);
        regra1.setRegra(RegraValor.MIN);

        RegraCredito regra2 = new RegraCredito();
        regra1.setNome("valorDivida");
        regra1.setReferencia("valorDivida");
        regra1.setValorReferencia(1000);
        regra1.setRegra(RegraValor.MAX);

        return Arrays.asList(regra1, regra2);
    }


}

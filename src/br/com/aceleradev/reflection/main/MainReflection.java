package br.com.aceleradev.reflection.main;


import br.com.aceleradev.reflection.credito.AnalisadorCredito;
import br.com.aceleradev.reflection.externo.Pessoa;

public class MainReflection {

    public static void main(String[] args) {
        Pessoa pessoa = getPessoa();
        AnalisadorCredito analisador = new AnalisadorCredito();
        boolean resultado = analisador.analisarCredito(pessoa);

        if(resultado)
            System.out.println("Credito aprovado");
        else
            System.out.println("Credito reprovado");
    }

    private static Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("123.456.789-10");
        pessoa.setNome("Joao");
        pessoa.setQuantidadeChequesDevolvidos(0);
        pessoa.setScoreSCPC(500);
        pessoa.setScoreSerasa(500);
        pessoa.setValorDivida(1000);
        return pessoa;
    }


}

package br.com.aceleradev.reflection.credito;

import br.com.aceleradev.reflection.externo.Pessoa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalisadorCredito {

    private RegrasCreditoRepository repository;

    public AnalisadorCredito() {
        this.repository = new RegrasCreditoRepository();
    }

    public boolean analisarCredito(Pessoa pessoa) {

        Method[] metodos = Pessoa.class.getDeclaredMethods();
        boolean regraValida=true;

        for (RegraCredito regra : repository.findAllRegras()) {
            for (Method metodo : metodos) {
                if(metodo.getName().toUpperCase().contains("GET"+regra.getReferencia().toUpperCase())){
                    try {
                        long valor = (long)metodo.invoke(pessoa);
                        regraValida = regra.valida(valor);
                        if(!regraValida)
                            return false;
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (Method metodo : metodos){
            System.out.println(metodo.getName());
        }


        return regraValida;
    }
}

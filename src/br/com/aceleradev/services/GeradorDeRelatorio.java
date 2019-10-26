package br.com.aceleradev.services;

import br.com.aceleradev.annotations.Coluna;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

public class GeradorDeRelatorio {

    public void gerarRelatorio(List<Object> usuarios, int qntColunas){
        gerarTitulos(usuarios, qntColunas);
        gerarLinhas(usuarios, qntColunas);
    }

    private void gerarTitulos(List<Object> usuarios, int qntColunas) {
        for(int i=1; i<=qntColunas; i++){
            System.out.print( getMetodoPorOrdem(usuarios.get(0).getClass(), i).getAnnotation(Coluna.class).titulo() );

            if(i<qntColunas)
                System.out.print(", ");
        }
        System.out.println();
    }

    private Method getMetodoPorOrdem(Class type, int ordem) {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Coluna.class)
                    && method.getAnnotation(Coluna.class).posicao()==ordem){
                return method;
            }
        }
        return null;
    }

    private void gerarLinhas(List<Object> usuarios, int qntColunas) {

        for (Object usuario : usuarios) {

            for(int i=1; i<=qntColunas; i++){
                try {
                    System.out.print( getMetodoPorOrdem(usuarios.get(0).getClass(), i).invoke(usuario) );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                if(i<qntColunas)
                    System.out.print(", ");
            }
            System.out.println();

        }


    }
}

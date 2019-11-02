package br.com.aceleradev.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainConexao {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso");
        factory.close();
    }
}

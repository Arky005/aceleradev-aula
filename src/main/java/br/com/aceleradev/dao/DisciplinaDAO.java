package br.com.aceleradev.dao;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;

import javax.persistence.EntityManager;
import java.util.List;

public class DisciplinaDAO {

    private EntityManager manager;

    public DisciplinaDAO(EntityManager manager){
        this.manager=manager;
    }

    //@Transactional
    public void save(Disciplina disciplina){
        manager.getTransaction().begin();
        manager.persist(disciplina);
        manager.getTransaction().commit();
    }

    public List<Disciplina> findAll(){
        //HQL - Hibernate Query Language
        //JPQL - Java Persistence Query Language - JPA
        return manager.createQuery("FROM Disciplina d").getResultList();
    }

    public void delete(Disciplina disciplina){
        manager.getTransaction().begin();
        manager.remove(disciplina);
        manager.getTransaction().commit();
    }

}

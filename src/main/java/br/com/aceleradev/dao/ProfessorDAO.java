package br.com.aceleradev.dao;

import br.com.aceleradev.domain.Professor;
import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDAO {

    private EntityManager manager;

    public ProfessorDAO(EntityManager manager){
        this.manager=manager;
    }

    //@Transactional
    public void save(Professor professor){
        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();
    }

    public List<Professor> findAll(){
        //HQL - Hibernate Query Language
        //JPQL - Java Persistence Query Language - JPA
        return manager.createQuery("FROM Professor p").getResultList();
    }

    public void delete(Professor professor){
        manager.getTransaction().begin();
        manager.remove(professor);
        manager.getTransaction().commit();
    }


}

package br.com.aceleradev.dao;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

public class AlunoDAO {

    private EntityManager manager;

    public AlunoDAO(EntityManager manager){
        this.manager=manager;
    }

    //@Transactional
    public void save(Aluno aluno){
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> findAll(){
        //HQL - Hibernate Query Language
        //JPQL - Java Persistence Query Language - JPA
        return manager.createQuery("FROM Aluno a").getResultList();
    }

    public void delete(Aluno aluno){
        manager.getTransaction().begin();
        manager.remove(aluno);
        manager.getTransaction().commit();
    }

    public List<Aluno> getAlunoPorDisciplina(Disciplina disciplina){
        Query query = manager.createQuery("FROM Aluno a INNER JOIN FETCH " +
                "a.disciplinas AS d WHERE d=?1");
        query.setParameter(1, disciplina);
        // :disciplina : query.setParameter("disciplina", disciplina);
        return query.getResultList();
    }

    public BigInteger getNumeroDisciplinasMatriculado(long idAluno){
        Query nativeQuery = manager.createNativeQuery("SELECT count(id_disciplina) FROM " +
                "disciplina_aluno WHERE id_aluno = ?1");
        nativeQuery.setParameter(1, idAluno);
        return (BigInteger) nativeQuery.getSingleResult();
    }


}

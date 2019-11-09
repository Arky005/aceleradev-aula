package br.com.aceleradev.main;

import br.com.aceleradev.dao.AlunoDAO;
import br.com.aceleradev.dao.DisciplinaDAO;
import br.com.aceleradev.dao.ProfessorDAO;
import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;
import br.com.aceleradev.domain.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainConexao {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso");
        EntityManager manager = factory.createEntityManager();

        AlunoDAO dao = new AlunoDAO(manager);
        dao.save(new Aluno("Otavio", "otavio123", "123.456.789.90", null));
        Aluno aluno = new Aluno("Lucas", "lucas123", "123.456.789.91", null);
        dao.save(aluno);
        dao.findAll().forEach(System.out::println);
        dao.delete(aluno);
        dao.findAll().forEach(System.out::println);

        ProfessorDAO professorDAO = new ProfessorDAO(manager);
        Professor professor1 = new Professor("Joao Linguiça", "prof123",
                "123.456.345-34", 1900);
        professorDAO.save(professor1);

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(manager);
        Disciplina matematica = new Disciplina("Matematica", professor1, Disciplina.Tipo.EXATAS);
        disciplinaDAO.save(matematica);
        disciplinaDAO.findAll().forEach(System.out::println);

        matematica.matricular(aluno);
        disciplinaDAO.findAll().forEach(System.out::println);

        dao.getAlunoPorDisciplina(matematica).forEach(System.out::println);


        factory.close();
    }
}

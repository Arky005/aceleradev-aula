package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.utils.DataLoader;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Aluno> listaAlunos = new ArrayList<>();
    static List<Professor> listaProfessores = new ArrayList<>();
    static List<Disciplina> listaDisciplinas = new ArrayList<>();

    public static void main(String[] args) {

        //questao1
        DataLoader.popularDeAlunos(listaAlunos);
        System.out.println(getMediaIdade());

        //questao2
        DataLoader.popularDeDisciplinas(listaDisciplinas);
        mostrarQntPorTipoDisciplina();

        //questao3
        DataLoader.matricularAlunos(listaDisciplinas);
        mostrarQntAlunosPorProf();

        //questao4
        DataLoader.popularDeProfessores(listaProfessores);
        mostrarAnosExperiencia();
    }

    public static void mostrarAnosExperiencia(){
        int anos=0;
        LocalDate dataAtual = LocalDate.now();

        for(int i=0; i<listaProfessores.size(); i++){
            anos+=(dataAtual.getYear()-listaProfessores.get(i).getAnoInicioCarreira());
        }
        System.out.println(anos/listaProfessores.size());
    }

    public static void mostrarQntAlunosPorProf(){
        for (Disciplina disciplina : listaDisciplinas) {
            System.out.println(disciplina.getProfessor().getNome()+": "+disciplina.getAlunos().size());
        }
    }

    public static void mostrarQntPorTipoDisciplina(){
        int qntExatas=0, qntBiologicas=0, qntHumanas=0;
        for (Disciplina disciplina : listaDisciplinas) {
            switch (disciplina.getTipo()){
                case EXATAS:
                    qntExatas++;
                    break;
                case HUMANAS:
                    qntHumanas++;
                    break;
                case BIOLOGICAS:
                    qntBiologicas++;
                    break;
            }
        }
        System.out.println("Exatas: "+qntExatas+
                "\nBiologicas: "+qntBiologicas+
                "\nHumanas: "+qntHumanas);
    }

    public static int getMediaIdade(){
        int idades=0;
        LocalDate dataAtual = LocalDate.now();

        for(int i=0; i<listaAlunos.size(); i++){
            idades+=dataAtual.getYear()-listaAlunos.get(i).getDataNascimento().getYear();
        }
        return idades/listaAlunos.size();
    }

}

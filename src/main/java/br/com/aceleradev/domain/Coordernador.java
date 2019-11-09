package br.com.aceleradev.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "coordenador")
public class Coordernador extends UsuarioAutorizavel {

    private long matricula;

    public Coordernador(long matricula, String nome, String login, String cpf, LocalDate nascimento) {
        super(nome, login, cpf, nascimento);
        this.matricula=matricula;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("COORD");
    }

}

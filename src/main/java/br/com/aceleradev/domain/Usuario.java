package br.com.aceleradev.domain;

import br.com.aceleradev.annotations.Coluna;
import br.com.aceleradev.exceptions.LoginInvalidoException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static br.com.aceleradev.utils.MensagemException.LOGIN_MENOR_DE_TRES_CARACTERES;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    public Usuario(String nome, String login, String cpf, LocalDate nascimento) {
        this.nome = nome;
        setLogin(login);
        this.cpf = cpf;
        this.dataNascimento=nascimento;
    }

    @Coluna(posicao=1, titulo="nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Coluna(posicao=3, titulo="login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(loginInvalido(login)){
            throw new LoginInvalidoException(LOGIN_MENOR_DE_TRES_CARACTERES);
        }

        this.login = login;

    }

    private boolean loginInvalido(String login) {
        return login.length() <= 3;
    }

    @Coluna(posicao=2, titulo="cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome
                + "\nlogin: " + this.login
                + "\ncpf: " + this.cpf + "\n";
    }

}

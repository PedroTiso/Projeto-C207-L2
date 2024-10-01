package br.inatel.Model;

public class Aluno {

    int id;

    String nome;

    int credito;

    public Aluno(int id, String nome, int credito) {
        this.id = id;
        this.nome = nome;
        this.credito = credito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
}


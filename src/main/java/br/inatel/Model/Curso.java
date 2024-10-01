package br.inatel.Model;

public class Curso {
    int id;
    String nome;
    int nvagas;

    public Curso(int id, String nome, int nvagas) {
        this.id = id;
        this.nome = nome;
        this.nvagas = nvagas;
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

    public int getNvagas() {
        return nvagas;
    }

    public void setNvagas(int nvagas) {
        this.nvagas = nvagas;
    }
}

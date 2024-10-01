package br.inatel;

import br.inatel.DAO.AlunoDao;
import br.inatel.Model.Aluno;

public class Main {
    public static void main(String[] args) {
        AlunoDao userDao = new AlunoDao();
        userDao.testConnection();

        Aluno aluno = new Aluno(100, "Pedro", 12);
        boolean s = userDao.insertAluno(aluno);
        System.out.println(s);


    }


}

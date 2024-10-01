package br.inatel.DAO;

import br.inatel.Model.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDao extends ConnectionDao {
    public void testConnection(){
        connectToDb();
    }

    public boolean insertAluno(Aluno aluno){
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO aluno (id, nome, credito) VALUES (?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, aluno.getId());
            pst.setString(2, aluno.getNome());
            pst.setInt(3, aluno.getCredito());
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean updateAluno(int id, Aluno aluno){
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE aluno SET nome = ?, credito = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setInt(2, aluno.getCredito());
            pst.setInt(3, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteAluno(int id){
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
           pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Aluno> selectUser() {
        connectToDb();

        ArrayList<Aluno> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuários:");
            while (rs.next()) {
                Aluno userAux = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getInt("credito"));
                System.out.println("Nome: " + userAux.getNome() + " CPF: " + userAux.getId());
                System.out.println("-------------------");
                users.add(userAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return users;
    }



}

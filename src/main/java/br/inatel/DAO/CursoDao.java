package br.inatel.DAO;

import br.inatel.Model.Aluno;
import br.inatel.Model.Curso;

import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDao extends ConnectionDao {
    public void testConnection(){
        connectToDb();
    }

    public boolean insertCurso(Curso curso){
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO curso (id, nome, nvagas) VALUES (?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, curso.getId());
            pst.setString(2, curso.getNome());
            pst.setInt(3, curso.getNvagas());
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

    public boolean updateCurso(int id, Curso curso){
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE curso SET nome = ?, nvagas = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, curso.getNome());
            pst.setInt(2, curso.getNvagas());
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

    public boolean deleteCurso(int id){
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM curso WHERE id = ?";
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

    public ArrayList<Curso> selectCurso() {
        connectToDb();

        ArrayList<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de cursos:");
            while (rs.next()) {
                Curso cursoAux = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("nvagas"));
                System.out.println("Nome: " + cursoAux.getNome() + " ID: " + cursoAux.getId());
                System.out.println("-------------------");
                cursos.add(cursoAux);
            }

        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return cursos;
    }



}

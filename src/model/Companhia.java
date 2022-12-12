package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DAO;
public class Companhia {

    public int id;
    public String nome;
    public String cnpj;

    public Companhia() {
    }

    public Companhia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        try {
            PreparedStatement ps = DAO.createConnection()
                    .prepareStatement("INSERT INTO companhia (id, nome, cnpj) VALUES (?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cnpj);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Companhia(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Companhia{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Companhia other = (Companhia) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        return true;
    }

    public void update(int id, String nome, String cnpj) {
        try {
            PreparedStatement ps = DAO.createConnection()
                    .prepareStatement("UPDATE companhia SET nome = ?, cnpj = ? WHERE id = ?");
            ps.setString(0, nome);
            ps.setString(1, cnpj);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement ps = DAO.createConnection().prepareStatement("DELETE FROM companhia WHERE id = ?");
            ps.setInt(0, id);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getById(int id) {
        try {
            PreparedStatement ps = DAO.createConnection().prepareStatement("SELECT * FROM companhia WHERE id = ?");
            ps.setInt(0, id);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getAll() {
        System.out.println("AQUI");
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM companhia");
            while (result.next()) {
                System.out.println(
                        result.getString("id") + " " + result.getString("nome") + " " + result.getString("cnpj"));
            }
            result.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getUltimoId() {
        int id = 0;
        try {
            Connection connection = DAO.createConnection();
            ResultSet result = connection.createStatement().executeQuery("SELECT MAX(id) FROM companhia");
            while (result.next()) {
                id = result.getInt("MAX(id)");
            }
            result.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

}
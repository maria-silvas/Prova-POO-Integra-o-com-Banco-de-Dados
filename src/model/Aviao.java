package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DAO;

public class Aviao extends Aeromodelo {

    private Generic<String, Integer> generic;
    private int capacidade;
    private int idCompanhia;
    private Companhia companhia;
    private String prefixo;

    public Aviao() {

    }

    public Aviao(int id, String marca, String modelo, Generic<String, Integer> numSerie, int capacidade,
            int idCompanhia) {
        super(id, marca, modelo);
        this.generic = numSerie;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;
        try {
            PreparedStatement ps = DAO.createConnection().prepareStatement(
                    "INSERT INTO aviao (id, marca, modelo, prefixo, capacidade, idCompanhia) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, generic.toString());
            ps.setInt(5, capacidade);
            ps.setInt(6, idCompanhia);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Aviao(String marca, String modelo, Generic<String, Integer> prefixo, int capacidade, int idCompanhia) {
        super(marca, modelo);
        this.generic = prefixo;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;

        try {
            PreparedStatement ps = DAO.createConnection().prepareStatement(
                    "INSERT INTO aviao (marca, modelo, prefixo, capacidade, idCompanhia) VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, prefixo.toString());
            ps.setInt(4, capacidade);
            ps.setInt(5, idCompanhia);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Generic<String, Integer> getPrefixoGeneric() {
        return generic;
    }

    public void setPrefixoGeneric(Generic<String, Integer> prefixo) {
        this.generic = prefixo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(int idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    @Override
    public String toString() {
        return "Aviao{" + "prefixo=" + prefixo.toString() + ", capacidade=" + capacidade + ", idCompanhia="
                + idCompanhia + ", companhia=" + companhia + '}';
    }

    public static void update(int id, String marca, String modelo, String prefixo, int capacidade, Companhia companhia,
            int idCompanhia) {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE aviao SET marca = ?, modelo = ?, prefixo = ?, capacidade = ?, idCompanhia = ? WHERE id = ?");
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, prefixo);
            ps.setInt(4, capacidade);
            ps.setInt(5, idCompanhia);
            ps.setInt(6, id);
            ps.execute();
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM aviao WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Aviao getById(int id) {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM aviao WHERE id = " + id);
            Aviao aviao = new Aviao();
            while (result.next()) {
                aviao.setId(result.getInt("id"));
                aviao.setMarca(result.getString("marca"));
                aviao.setModelo(result.getString("modelo"));
                aviao.setPrefixo(result.getString("prefixo"));
            }
            result.close();
            connection.close();
            return aviao;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void getAll() {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM aviao");
            while (result.next()) {
                System.out.println(
                        result.getString("marca")
                                + " " + result.getString("modelo")
                                + " " + result.getString("prefixo")
                                + " " + result.getInt("capacidade")
                                + " " + result.getInt("idCompanhia"));

            }
            result.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getUltimoId() {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT MAX(id) FROM aviao");
            int id = 0;
            while (result.next()) {
                id = result.getInt("MAX(id)");
            }
            result.close();
            connection.close();
            return id;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
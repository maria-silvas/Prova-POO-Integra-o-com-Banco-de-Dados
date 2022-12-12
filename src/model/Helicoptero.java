package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DAO;

public class Helicoptero extends Aeromodelo {

    private String cor;
    private int capacidade;

    public Helicoptero() {

    }

    public Helicoptero(int id, String marca, String modelo, String cor, int capacidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
        try {
            PreparedStatement prepare = DAO.createConnection()
                    .prepareStatement("INSERT INTO helicoptero (id, cor, capacidade) VALUES (?, ?, ?)");
            prepare.setInt(1, id);
            prepare.setString(2, cor);
            prepare.setInt(3, capacidade);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Helicoptero(String marca, String modelo, String cor, int capacidade) {
        super(marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Helicoptero{" + "cor=" + cor + ", capacidade=" + capacidade + '}';
    }

    public static void update(int id, String marca, String modelo, String cor, int capacidade) {
        try {
            PreparedStatement prepare = DAO.createConnection().prepareStatement(
                    "UPDATE helicoptero SET marca = ?, modelo = ?, cor = ?, capacidade = ? WHERE id = ?");
            prepare.setString(1, marca);
            prepare.setString(2, modelo);
            prepare.setString(3, cor);
            prepare.setInt(4, capacidade);
            prepare.setInt(5, id);
            prepare.execute();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement prepare = DAO.createConnection().prepareStatement("DELETE FROM helicoptero WHERE id = ?");
            prepare.setInt(1, id);
            prepare.execute();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Helicoptero getById(int id) {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM helicoptero WHERE id = " + id);
            while (result.next()) {
                return new Helicoptero(result.getString("marca"), result.getString("modelo"), result.getString("cor"),
                        result.getInt("capacidade"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void getAll() {
        try {
            ResultSet result = DAO.createConnection().createStatement().executeQuery("SELECT * FROM helicoptero");
            while (result.next()) {
                System.out.println("id: " + result.getInt("id") + " marca: " + result.getString("marca") + " modelo: "
                        + result.getString("modelo") + " cor: " + result.getString("cor") + " capacidade: "
                        + result.getInt("capacidade"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int getUltimoId() {
        try {
            ResultSet result = DAO.createConnection().createStatement().executeQuery("SELECT MAX(id) FROM helicoptero");
            while (result.next()) {
                return result.getInt("MAX(id)");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
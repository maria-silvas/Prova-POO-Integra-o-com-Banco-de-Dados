package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DAO;

public class Jato extends Aeromodelo {
    // classe inicial
    private String cor;
    private int velocidade;

    public Jato() {

    }

    public Jato(String marca, String modelo, String cor, int velocidade) {
        super(marca, modelo);
        this.cor = cor;
        this.velocidade = velocidade;
    }

    public Jato(int id, String marca, String modelo, String cor, int velocidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.velocidade = velocidade;

        try {
            PreparedStatement prepare = DAO.createConnection()
                    .prepareStatement("INSERT INTO jato (id, cor, velocidade) VALUES (?, ?, ?)");
            prepare.setInt(1, id);
            prepare.setString(2, cor);
            prepare.setInt(3, velocidade);
            prepare.execute();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "Jato{" + "cor=" + cor + ", velocidade=" + velocidade + '}';
    }

    public static void update(int id, String marca, String modelo, String cor, int velocidade) {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement prepare = connection
                    .prepareStatement("UPDATE jato SET marca = ?, modelo = ?, cor = ?, velocidade = ? WHERE id = ?");
            prepare.setString(1, marca);
            prepare.setString(2, modelo);
            prepare.setString(3, cor);
            prepare.setInt(4, velocidade);
            prepare.setInt(5, id);
            prepare.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar jato: " + e);
        }
    }

    public static void delete(int id) {
        Connection connection = DAO.createConnection();
        try {
            PreparedStatement prepare = connection.prepareStatement("DELETE FROM jato WHERE id = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar jato: " + e);
        }
    }

    public static Jato getById(int id) {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM jato WHERE id = " + id);
            while (result.next()) {
                return new Jato(result.getString("marca"), result.getString("modelo"), result.getString("cor"),
                        result.getInt("velocidade"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar jato: " + e);
        }
        return null;
    }

    public static void getAll() {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM jato");
            while (result.next()) {
                System.out.println("Id: " + result.getInt("id") + " Marca: " + result.getString("marca") + " Modelo: "
                        + result.getString("modelo") + " Cor: " + result.getString("cor") + " Velocidade: "
                        + result.getInt("velocidade"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar jatos: " + e);
        }
    }

    public static int getUltimoId() {
        Connection connection = DAO.createConnection();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM jato ORDER BY id DESC LIMIT 1");
            while (result.next()) {
                return result.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar ultimo id: " + e);
        }
        return 0;
    }
}
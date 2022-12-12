package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.DAO;

public class Pista {

    private int id;
    private Generic<String, Integer> generic;
    private String numero;

    public static ArrayList<Pista> pistas = new ArrayList<Pista>();

    public Pista() {

    }

    public Pista(int id, Generic<String, Integer> generic) {
        this.id = id;
        this.generic = generic;

        try {
            PreparedStatement preparacao = DAO.createConnection()
                    .prepareStatement("INSERT INTO pista (id, numero) VALUES (?, ?)");
            preparacao.setInt(1, id);
            preparacao.setString(2, numero.toString());
            preparacao.execute();
            preparacao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Pista(Generic<String, Integer> numero) {
        this.generic = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Generic<String, Integer> getNumeroGeneric() {
        return generic;
    }

    public void setNumeroGeneric(Generic<String, Integer> numero) {
        this.generic = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pista{" + "id=" + id + ", numero=" + numero.toString() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pista other = (Pista) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        return true;
    }

    public static void update(int id, Generic<String, Integer> numero) {
        try {
            PreparedStatement prepare = DAO.createConnection()
                    .prepareStatement("UPDATE pista SET numero = ? WHERE id = ?");
            prepare.setString(1, numero.toString());
            prepare.setInt(2, id);
            prepare.execute();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement prepare = DAO.createConnection().prepareStatement("DELETE FROM pista WHERE id = ?");
            prepare.setInt(1, id);
            prepare.execute();
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Pista getByPista(int id) {
        Connection con = DAO.createConnection();
        try {
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM pista WHERE id = " + id);
            Pista pista = new Pista();
            while (result.next()) {
                pista.setId(result.getInt("id"));
                pista.setNumero(result.getString("numero"));
                return pista;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void getAll() {
        Connection con = DAO.createConnection();
        try {
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM pista");
            while (result.next()) {
                System.out.println("ID: " + result.getInt("id") + " Numero: " + result.getString("numero"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static int getUltimoId() {
        Connection con = DAO.createConnection();
        try {
            ResultSet result = con.createStatement().executeQuery("SELECT MAX(id) FROM pista");
            while (result.next()) {
                return result.getInt("MAX(id)");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
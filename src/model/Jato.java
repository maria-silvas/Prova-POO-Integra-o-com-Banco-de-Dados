package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import database.DAO;

public class Jato<Int> extends Aeronave {

    private String cor;

    private static int velocidade;

    public static ArrayList<Jato> jatos = new ArrayList<Jato>();

    public Jato(int id, String marca, String cor, String velocidade, int velocidade) {
        super(id, marca, velocidade);
        this.cor = cor;
        this.velocidade = velocidade;

        jatos.add(this);
    }

    public Jato(ResultSet rs) {
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidade(int velocidade) {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public static Jato getJatoById(int id) {
        for (Jato jato : Jato.jatos) {
            if (jato.id == id) {
                return jato;
            }
        }

        return null;
    }

    public static Jato deleteJatoById(int id) {
        for (Jato jato : Jato.jatos) {
            if (jato.id == id) {
                Jato.jatos.remove(jato);
                return jato;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "| Cor: " + this.cor + "| Velocidade: " + this.velocidade;
    }

    public static void printAviao(
            ArrayList<Jato> aviaos) {
        try {
            for (Jato jato : aviaos) {
                System.out.println(jato);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Jato> geJato() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM jato;");
            ArrayList<Jato> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                        new Jato(rs));
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Jato getJatoInsert(Scanner scanner) {

        System.out.println("Informe a cor do Jato");
        String cor = scanner.next();
        System.out.println("Informe o velocidade do Jato");
        String velocidade = scanner.next();

        return new Jato(
                new Prefixo<String, Integer>(null, null),
                cor,
                velocidade);
    }

    public static void insertJatoS(Jato jato) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into jato "
                    + "(cor,velocidade) VALUES "
                    + "('" + jato.getCor() + "', '" + jato.getVelocidade() + "')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(jato);
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Jato getJato (Scanner scanner) throws Exception {
        try {
            Jato jato = getJato(scanner);
            System.out.println("Informe a cor dO Jato ");
            String cor = scanner.next();
            System.out.println("Informe o velocidade do avião");
            String velocidade = scanner.next();
            return jato;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateJato (Jato jato) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE jato SET "

                    + ", cor = '" + jato.getCor() + "'"
                    + ", velocidade = '" + jato.getVelocidade(velocidade) + "'"

                    + " WHERE id = " + jato.getId());
            System.out.println("Dados atualizados com sucesso");
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Jato getJato(Scanner scanner) throws Exception {
        try {
            System.out.println("Informe o ID do jato: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM jato WHERE id = " + id);

            if (!rs.next()) {
                throw new Exception("Id inválido");
            }

            Jato jato = new Jato(rs);
            DAO.deleteConnect();
            return jato;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteJato(Jato jato) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM jato WHERE id = ?");
            pStm.setInt(1, jato.getId());
            System.out.println("Dados deletado com sucesso");
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
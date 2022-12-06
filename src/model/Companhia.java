package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

import database.DAO;

public class Companhia {
    private String nome;
    private String cnpj;
    private int id;

    public static ArrayList<Companhia> companhias = new ArrayList<Companhia>();

    public Companhia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;

        companhias.add(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static Companhia getComapnhiaById(Companhia companhia2) {
        for (Companhia companhia : Companhia.companhias) {
            if (companhia.id == companhia.id) {
                return companhia;
            }
        }

        return null;
    }

    public static Companhia deleteComapnhiaById(int id) {
        for (Companhia companhia : Companhia.companhias) {
            if (companhia.id == id) {
                Companhia.companhias.remove(companhia);
                return companhia;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "Nome: " + this.nome + "| Cnpj:" + this.cnpj;
    }

    public static void printAviao(
            ArrayList<Companhia> companhias) {
        try {
            for (Companhia companhia : companhias) {
                System.out.println(companhia);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // public static ArrayList<Companhia> getAviaoS() throws Exception {
    // try {
    // System.out.println("Conectando ao banco de dados");
    // Connection con = DAO.getConnect();
    // Statement stm = con.createStatement();
    // System.out.println("Banco de Dados conectado");
    // System.out.println("Mostrando dados presente no banco de dados");
    // ResultSet rs = stm.executeQuery("SELECT * FROM companhia;");
    // ArrayList<Companhia> companhias = new ArrayList<>();
    // while (rs.next()) {
    // companhias.add(
    // new Companhia(rs));
    // }
    // DAO.deleteConnect();
    // return companhias;
    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    // }

    public static Companhia getAviaoInsert(Scanner scanner) {

        System.out.println("Informe o nome da Companhia");
        String nome = scanner.next();
        System.out.println("Informe o Cnpj Companhia");
        String cnpj = scanner.next();

        return new Companhia(0, nome, cnpj);
    }

    public static void insertCompanhiaS(Companhia companhia) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = (Statement) con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into companhia "
                    + "(nome,cnpj) VALUES "
                    + "('" + companhia.getNome() + "', '" + companhia.getCnpj().getId() + "')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(companhia);
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Companhia getAviaoUpdate(Scanner scanner) throws Exception {
        try {
            Companhia companhia = getAviao(scanner);
            System.out.println("Informe a marca do companhia");
            String marca = scanner.next();
            System.out.println("Informe o modelo do Companhia");
            String modelo = scanner.next();
            System.out.println("Informe a capacidade do Companhia");
            String capacidade = scanner.next();
            return companhia;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateAviaoS(Companhia companhia) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE companhia SET "
                    + " marca = '" + companhia.getMarca() + "'"
                    + ", modelo = '" + companhia.getModelo() + "'"
                    + ", capacidade = '" + companhia.getCapacidade() + "'"
                    + ", id_companhia = '" + companhia.getCompanhia().getId() + "'"
                    + " WHERE id = " + companhia.getId());
            System.out.println("Dados atualizados com sucesso");
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Companhia getAviao(Scanner scanner) throws Exception {
        try {
            System.out.println("Informe o ID do companhia: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM companhia WHERE id = " + id);

            if (!rs.next()) {
                throw new Exception("Id inválido");
            }

            Companhia companhia = new Companhia(rs);
            DAO.deleteConnect();
            return companhia;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteAviaoPS(Companhia companhia) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM companhia WHERE id = ?");
            pStm.setInt(1, companhia.getId());
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
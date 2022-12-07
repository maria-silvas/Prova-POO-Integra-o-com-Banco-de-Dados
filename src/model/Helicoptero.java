package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import database.DAO;

public class Helicoptero extends Aeronave {

    private String cor;
    private int capacidade;
    public static ArrayList<Helicoptero> helicopteros = new ArrayList<Helicoptero>();

    public Helicoptero(int id, String marca, String modelo, String cor, int capacidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
        helicopteros.add(this);
    }

    public Helicoptero(ResultSet rs) {
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

    public static Helicoptero getHelicopteroyId(int id) {
        for (Helicoptero helicoptero : Helicoptero.helicopteros) {
            if (helicoptero.id == id) {
                return helicoptero;
            }
        }

        return null;
    }

    public static Helicoptero deleteHelicopteroById(int id) {
        for (Helicoptero helicoptero : Helicoptero.helicopteros) {
            if (helicoptero.id == id) {
                Helicoptero.helicopteros.remove(helicoptero);
                return helicoptero;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "| Cor: " + this.cor + "| Capacidade: " + this.capacidade;
    }

    public static void printHelicoptero(
            ArrayList<Helicoptero> aviaos) {
        try {
            for (Helicoptero helicoptero : aviaos) {
                System.out.println(helicoptero);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Helicoptero> getHalicoptero() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM helicoptero;");
            ArrayList<Helicoptero> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                        new Helicoptero(rs));
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Helicoptero getHelicopteroInsert(Scanner scanner) {
        
        System.out.println("Informe a cor do Helicoptero");
        String cor = scanner.next();
        System.out.println("Informe o capacidadedo Helicoptero");
        String capacidade= scanner.next();


        Helicoptero helicoptero = new Helicoptero(
           
         
            cor,
            capacidade,
        );
        return helicoptero;
    }

    public static void insertHelicoptero(Helicoptero helicoptero) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into helicoptero "
                    + "(cor, modelo, capacidade,companhia) VALUES "
                    + "('" + helicoptero.getCor() + "', '" + helicoptero.getCapacidade());
            System.out.println("Dados inseridos com sucesso");
            System.out.println(helicoptero);
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Helicoptero getHalicopteroUpdate(Scanner scanner) throws Exception {
        try {
            Helicoptero helicoptero = getHelicoptero(scanner);
            System.out.println("Informe a cor do helicoptero");
            String cor = scanner.next();
            System.out.println("Informe o capacidadedo Helicoptero");
            String capacidade = scanner.next();
            return helicoptero;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateHelicoptero(Helicoptero helicoptero) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE helicoptero SET "
                    + " cor = '" + helicoptero.getCor() + "'"
                    + ", capacidade= '" + helicoptero.getModelo() + "'"
                    + ", capacidade = '" + helicoptero.getCapacidade() + "'"
                    + " WHERE id = " + helicoptero.getId());
            System.out.println("Dados atualizados com sucesso");
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Helicoptero getHelicoptero(Scanner scanner) throws Exception {
        try {
            System.out.println("Informe o ID do helicoptero: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM helicoptero WHERE id = " + id);

            if (!rs.next()) {
                throw new Exception("Id inválido");
            }

            Helicoptero helicoptero = new Helicoptero(rs);
            DAO.deleteConnect();
            return helicoptero;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteHelicoptero(Helicoptero helicoptero) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM helicoptero WHERE id = ?");
            pStm.setInt(1, helicoptero.getId());
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
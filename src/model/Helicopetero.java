package model;

import java.util.ArrayList;
import database.DAO;

public class Helicopetero extends Aeronave {

    private String cor;
    private int capacidade;
    public static ArrayList<Helicopetero> helicopeteros = new ArrayList<Helicopetero>();

    public Helicopetero(int id, String cor, String cor, String modelo, int capacidade) {
        super(id, cor, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
        helicopeteros.add(this);
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

    public static Helicopetero getHelicopeteroyId(int id) {
        for (Helicopetero helicopetero : Helicopetero.helicopeteros) {
            if (helicopetero.id == id) {
                return helicopetero;
            }
        }

        return null;
    }

    public static Helicopetero deleteHelicopeteroById(int id) {
        for (Helicopetero helicopetero : Helicopetero.helicopeteros) {
            if (helicopetero.id == id) {
                Helicopetero.helicopeteros.remove(helicopetero);
                return helicopetero;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "| Id: " + this.id + "| cor: " + this.cor + "| Modelo: " + this.capacidade+ "| Cor: "
                + this.cor + "| Capacidade: " + this.capacidade;
    }


    public static void printAviao(
        ArrayList<Helicopetero> aviaos
    ) {
        try {
            for (Helicopetero helicopetero : aviaos) {
                System.out.println(helicopetero);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Helicopetero> getAviaoS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM helicopetero;");
            ArrayList<Helicopetero> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                    new Helicopetero(rs)
                );
            }
            DAO.deleteConnect();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Helicopetero getAviaoInsert(Scanner scanner) {
        
        System.out.println("Informe a cor do Helicopetero");
        String cor = scanner.next();
        System.out.println("Informe o capacidadedo Helicopetero");
        String capacidade= scanner.next();


        Helicopetero helicopetero = new Helicopetero(
           
         
            cor,
            capacidade,
        );
        return helicopetero;
    }

    public static void insertHelicopeteroS(Helicopetero helicopetero) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into helicopetero "
                + "(cor, modelo, capacidade,companhia) VALUES "
                + "('"+helicopetero.getCor()+"', '"+helicopetero.getCapacidade());
            System.out.println("Dados inseridos com sucesso");
            System.out.println(helicopetero); 
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Helicopetero getHalicopeteroUpdate(Scanner scanner) throws Exception {
        try {
            Helicopetero helicopetero = getAviao(scanner);
            System.out.println("Informe a cor do helicopetero");
            String cor = scanner.next();
            System.out.println("Informe o capacidadedo avião");
            String capacidade= scanner.next();
            return helicopetero;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateAviaoS(Helicopetero helicopetero) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE helicopetero SET "
                + " cor = '" + helicopetero.getCor() + "'"
                + ", capacidade= '" + helicopetero.getModelo() + "'"
                + ", capacidade = '" + helicopetero.getCapacidade() + "'"
                + " WHERE id = " + helicopetero.getId());
                System.out.println("Dados atualizados com sucesso"); 
            DAO.deleteConnect();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Helicopetero getAviao(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do helicopetero: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM helicopetero WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            Helicopetero helicopetero = new Helicopetero(rs);
            DAO.deleteConnect();
            return helicopetero;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteHelicopeteroS(Helicopetero helicopetero) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DAO.getConnect();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM helicopetero WHERE id = ?");
            pStm.setInt(1, helicopetero.getId());
            System.out.println("Dados deletado com sucesso");  
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            DAO.deleteConnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
// Importando as bibliotecas padrões e as packages.
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;

// Criando a classe DAO.
public class AeroportoDao {
    private Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
 
    public static void printAviao(
        ArrayList<Aviao> aviaos
    ) {
        try {
            for (Aviao aviao : aviaos) {
                System.out.println(aviao);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Aviao> getAviaoS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM aviao;");
            ArrayList<Aviao> aviaos = new ArrayList<>();
            while (rs.next()) {
                aviaos.add(
                    new Aviao(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("capacidade"),
                        rs.getInt("id_companhia")
                    )
                );
            }
            con.close();
            return aviaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Cliente getAviaoInsert(Scanner scanner) {
        
        System.out.println("Informe a marca do Aviao");
        String marca = scanner.next();
        System.out.println("Informe o modelo do Aviao");
        String modelo = scanner.next();
        System.out.println("Informe a capacidade do Aviao");
        String capacidade = scanner.next();

        return new Aviao(
            marca,
            modelo,
            capacidade
        );
    }

    public static void insertAviaoS(Aviao aviao) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into aviao "
                + "(marca, modelo, capacidade,companhia) VALUES "
                + "('"+aviao.getMarca()+"', '"+aviao.getModelo()+"', '"+aviao.getCapacidade()+"', '"+aviao.getCompanhia().getIdCompanhia()+"')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(aviao); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getAviaoUpdate(Scanner scanner) throws Exception {
        try {
            Aviao aviao = getAviao(scanner);
            System.out.println("Informe a marca do aviao");
            String marca = scanner.next();
            System.out.println("Informe o modelo do avião");
            String modelo = scanner.next();
            System.out.println("Informe a capacidade do avião");
            String capacidade = scanner.next();
            return aviao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateAviaoS(Aviao aviao) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE aviao SET "
                + " marca = '" + aviao.getMarca() + "'"
                + ", modelo = '" + aviao.getModelo() + "'"
                + ", capacidade = '" + aviao.getCapacidade() + "'"
                + ", id_companhia = '" + aviao.getCompanhia().getIdCompanhia()+ "'"
                + " WHERE id = " + aviao.getIdAeronave());
                System.out.println("Dados atualizados com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getAviao(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do aviao: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM aviao WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            return new Aviao(
                rs.getInt("id"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("capacidade"),
                rs.getInt("id_companhia")
            );
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteAviaoPS(Aviao aviao) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM aviao WHERE id = ?");
            pStm.setInt(1, aviao.getIdAeronave());
            System.out.println("Dados deletado com sucesso");  
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
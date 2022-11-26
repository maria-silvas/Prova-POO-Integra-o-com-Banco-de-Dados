// Importando as bibliotecas padrões e as packages.
package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import src.model.Aviao;


// Criando a classe DAO.
public class AeroportoDAO {
    private Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/aeoroporto-sql?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // Criando as regras de negocio do CRUD e da conexão ao banco de dados do
    
    public static void SelectAeoronave(Aeroporto aeroporto) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            String sql1 = "SELECT * FROM Aeronave";
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aeoroporto-sql?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery(sql1);
            while (rs.next()) {
                stm.execute("SELECT * FROM jaula WHERE id = " + rs.getInt("aviao_id"));
                aeroporto = new Aviao(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getInt(""));
                System.out.println(aeroporto);
            }
            con.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());sss
        }
    }

    public static Aviao getAviaoInsert(Scanner scanner) {
        System.out.println("Informe a marca do Avião: ");
        String marca = scanner.next();
        System.out.println("Informe o Modelo do Avião ");
        String modelo =  = scanner.next();
        System.out.println("Informe o Prefixo do Aviao");
        String prefixo = scanner.next();
        return new Aviao(
                marca,
                modelo,
                prefixo);
    }
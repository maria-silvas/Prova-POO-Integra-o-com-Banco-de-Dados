package database;

import database.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Criando a classe DAO.
public class DAO {
    private static Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/aeroporto?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public static Connection getConnect() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(url, user, password);
        }

        return con;
    }

    public static void deleteConnect() throws SQLException {
        getConnect().close();
    }

    public static Connection createConnection() {
        return null;
    }
}
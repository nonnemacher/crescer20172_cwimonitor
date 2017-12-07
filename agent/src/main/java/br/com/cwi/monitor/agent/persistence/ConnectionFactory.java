package br.com.cwi.monitor.agent.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Alvaro
 * Classe prove uma conexão com o banco sendo utilizado.
 */
public class ConnectionFactory {
    
    private static final String connectionString = "jdbc:sqlite:C://Users/Alvaro/Desktop/DEV/Monitor/test.db";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionString);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

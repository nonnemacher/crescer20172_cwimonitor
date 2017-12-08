package br.com.cwi.monitor.agent.persistence;

import br.com.cwi.monitor.agent.StopWatch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Alvaro
 * Classe prove uma conexão com o banco sendo utilizado.
 */
public class ConnectionFactory {
    
    private static final String connectionString = "jdbc:sqlite:test.db";
    
    public static Connection getConnection() {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionString);
        }
        catch (SQLException e) {
            e.printStackTrace();
               
        }
        stopWatch.stop();
        System.out.println("Tempo para abrir connection " + stopWatch.getTotalTimeMillis());
        return conn;
    }
}

package br.com.cwi.monitor.agent.persistence.repository;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alvaro
 */
public class InfoRepositorySQLiteImplementation implements InfoRepository {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    @Override
    public void save(Info info) {
        String sql = "insert into INFO(MEMORIA, CPU, DISCO, HORA) values (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, info.getMemoria());
            pstmt.setDouble(2, info.getCPU());
            pstmt.setDouble(3, info.getDisco());
            pstmt.setObject(4, info.getHora());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // ..
        }
    }

    @Override
    public void delete(Info info) {
        String sql = "delete from INFO where ID = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, info.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // ..
        }
    }

    @Override
    public void delete(List<Info> infos) {
        String sql = "delete from INFO where ID in (?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, infos.stream()
                    .map(Info::getId)
                    .map(l -> l.toString())
                    .collect(Collectors.joining(",")));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // ..
        }
    }

    @Override
    public List<Info> retrieve(int n) {
        String sql = "select ID, MEMORIA, CPU, DISCO, HORA from INFO order by HORA asc limit " + n;
        ArrayList<Info> infos = new ArrayList();
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Info info = new Info();
                info.setId(rs.getLong("ID"));
                info.setMemoria(rs.getDouble("MEMORIA"));
                info.setCPU(rs.getDouble("CPU"));
                info.setDisco(rs.getDouble("DISCO"));
                info.setHora(LocalDateTime.parse(rs.getString("HORA")));
                infos.add(info);
            }
        } catch (SQLException e) {
            // ..
        }
        return infos;
    }

    @Override
    public int getCount() {
        final String sql = "select count(1) as total from INFO";
        int total = 0;

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            total = rs.getInt("total");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void dropTable() {
        final String sql = "drop table INFO";
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        final String sql = "create table if not exists INFO (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "MEMORIA REAL NOT NULL,"
                + "CPU REAL NOT NULL,"
                + "DISCO REAL NOT NULL,"
                + "HORA INTEGER NOT NULL)";

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

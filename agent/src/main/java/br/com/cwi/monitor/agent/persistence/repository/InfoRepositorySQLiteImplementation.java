package br.com.cwi.monitor.agent.persistence.repository;

import br.com.cwi.monitor.agent.entity.Info;
import br.com.cwi.monitor.agent.persistence.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "insert into INFO(MEMORY, TOTAL_MEMORY, CPU, NUMBER_CORES, FREE_DISK, OCCUPIED_DISK, TIME) values (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, info.getMemory());
            pstmt.setDouble(2, info.getTotalMemory());
            pstmt.setDouble(3, info.getCpu());
            pstmt.setDouble(4, info.getNumberOfCores());
            pstmt.setDouble(5, info.getFreeDisk());
            pstmt.setDouble(6, info.getOccupiedDisk());
            pstmt.setLong(7, info.getTime());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(List<Info> infos) {

        String sql = String.format("delete from INFO where ID in (%s)", infos.stream()
                .map(Info::getId)
                .map(l -> l.toString())
                .collect(Collectors.joining(",")));
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Info> retrieve(int n) {
        String sql = "select ID, MEMORY, TOTAL_MEMORY, CPU, NUMBER_CORES, FREE_DISK, OCCUPIED_DISK, TIME from INFO order by TIME asc limit " + n;
        ArrayList<Info> infos = new ArrayList();
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Info info = new Info();
                info.setId(rs.getLong("ID"));
                info.setMemory(rs.getDouble("MEMORY"));
                info.setTotalMemory(rs.getDouble("TOTAL_MEMORY"));
                info.setCpu(rs.getDouble("CPU"));
                info.setNumberOfCores(rs.getInt("NUMBER_CORES"));
                info.setFreeDisk(rs.getDouble("FREE_DISK"));
                info.setOccupiedDisk(rs.getDouble("OCCUPIED_DISK"));
                info.setTime(rs.getLong("TIME"));
                infos.add(info);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        return total;
    }

    public void dropTable() {
        final String sql = "drop table INFO";
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable() {
        final String sql = "create table if not exists INFO ("
                + "  ID INTEGER PRIMARY KEY AUTOINCREMENT"
                + ", MEMORY REAL NOT NULL"
                + ", TOTAL_MEMORY REAL NOT NULL"
                + ", CPU REAL NOT NULL"
                + ", NUMBER_CORES INTEGER NOT NULL"
                + ", FREE_DISK REAL NOT NULL"
                + ", OCCUPIED_DISK REAL NOT NULL"
                + ", TIME INTEGER NOT NULL)";
        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

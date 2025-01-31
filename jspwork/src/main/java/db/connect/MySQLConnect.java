package db.connect;

import java.sql.*;

public class MySQLConnect {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username = "root";
    String password = "12345678";

    public MySQLConnect() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("mysql driver 실패 : " + e.getMessage());
        }
    }
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("mysql 연결 실패 : " + e.getMessage());
        }
        return conn;
    }
    
    public void dbClose(PreparedStatement ps, Connection conn) {
        try {
            ps.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}

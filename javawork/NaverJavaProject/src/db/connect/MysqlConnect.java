package db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username = "root";
    String password = "12345678";

    public MysqlConnect() {
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

    public void dbClose(PreparedStatement pstmt, Connection conn) {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
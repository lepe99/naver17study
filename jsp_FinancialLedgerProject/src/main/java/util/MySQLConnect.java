package util;

import java.sql.*;

public class MySQLConnect {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    // ncloud db
    String url = "jdbc:mysql://db-324oca-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
    String username = "study";
    String password = "*!%bitcamp815";

    public MySQLConnect() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("mysql driver 실패 : " + e.getMessage());
        }
    }
    
    public Connection getNCloudConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("nCloud mysql 서버 접속 실패 : " + e.getMessage());
        }
        return conn;
    }
    
    public void dbClose(PreparedStatement ps, Connection conn) {
        try {
            ps.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
        }
    }
    
    public void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException | NullPointerException e) {
        }
    }
}

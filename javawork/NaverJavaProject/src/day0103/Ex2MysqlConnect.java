package day0103;

import java.sql.*;

public class Ex2MysqlConnect {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    // db에 접근하려면 url과 id, password가 필요하다
    String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username = "root";
    String password = "12345678";

    public Ex2MysqlConnect() {
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql 드라이버 실패 : " + e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Mysql 접속 성공");
        } catch (SQLException e) {
            System.out.println("Mysql 접속 실패 : " + e.getMessage());
        }
        return conn;
    }

    public void personWriteData() {
        Connection conn = null;
        conn = this.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        // 방법 1
        // String sql = "select name, age, blood, hp, date_format(today, '%Y-%m-%d %H:%i') from person"

        // 방법 2 - jdk17 추가 - 멀티라인텍스트
        String sql = """
            select name, age, blood, hp, date_format(today, '%Y-%m-%d %H:%i') date from person
            """;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("이름\t\t나이\t혈액형\t전화번호\t날짜");
            System.out.println("=".repeat(40));

            while (rs.next()) {
                String pName = rs.getString("name");
                int pAge = rs.getInt("age");
                String pBlood = rs.getString("blood");
                String pHp = rs.getString("hp");
                String pDate = rs.getString("date");

                System.out.println(pName + "\t" + pAge + "\t" + pBlood + "\t\t" + pHp + "\t" + pDate);
            }

        } catch (SQLException e) {
            System.out.println("SQL문 오류 : " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
        ex2.personWriteData();
    }
}

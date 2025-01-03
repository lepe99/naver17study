package day0103;

import java.sql.*;

public class Ex1OracleConnect {

    static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    // db에 접근하려면 url과 id, password가 필요하다
    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String username = "angel";
    String password = "pw1234";

    public Ex1OracleConnect() {
        try {
            Class.forName(ORACLE_DRIVER);
            System.out.println("오라클 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버 실패 : " + e.getMessage());
        }
    }

    // db 연결 성공 후 Connection을 반환하는 메서드
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("오라클 접속 성공");
        } catch (SQLException e) {
            System.out.println("오라클 접속 실패 : " + e.getMessage());
        }
        return conn;
    }

    public void shopWriteData() {
        Connection conn = null;
        Statement stmt = null; // java.SQL 사용
        ResultSet rs = null;
        String sql = "select * from shop";

        conn = this.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); // select sql문은 resultSet이 반환되는 excuteQuery만 가능!
            // 레코드가 여러개인 경우 while 문으로  rs.next()가 true 인 동안만 반복
            System.out.println("상품코드/상품명/가격");
            System.out.println("=".repeat(20));

            while (rs.next()) {
                String code = rs.getString("prdtcode"); // columnindex, columnlabel 두개의 옵션
                String pName = rs.getString("prdtname");
                int pPrice = rs.getInt("prdtprice");

                System.out.println(code + "\t" + pName + "\t" + pPrice);
            }

        } catch (SQLException e) {
            System.out.println("SQL문 오류 : " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Ex1OracleConnect ex1 = new Ex1OracleConnect(); // 생성자 호출
        ex1.shopWriteData();
    }
}



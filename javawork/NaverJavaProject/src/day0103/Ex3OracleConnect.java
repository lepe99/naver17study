package day0103;

import java.sql.*;

public class Ex3OracleConnect {
    static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String username = "angel";
    String password = "pw1234";

    public Ex3OracleConnect() {
        try {
            Class.forName(ORACLE_DRIVER);
            System.out.println("드라이버 불러오기 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 불러오기 실패 : " + e.getMessage());
        }
    }

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
        conn = this.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String sql = """
                select s.PRDTCODE, PRDTNAME, PRDTPRICE, CNTNUM, to_char(CARTDAY, 'yyyy-mm-dd') CARTDAY
                from SHOP s, CART c
                where s.PRDTCODE = c.PRDTCODE
                """;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("상품코드\t상품명\t상품가격\t상품개수\t등록일");
            System.out.println("=".repeat(50));

            while (rs.next()) {
                String pCode = rs.getString("PRDTCODE");
                String pName = rs.getString("PRDTNAME");
                String pPrice = rs.getString("PRDTPRICE");
                int cntNum = rs.getInt("CNTNUM");
                String cartDay = rs.getString("CARTDAY");

                System.out.println(pCode + "\t" + pName + "\t" + pPrice + "\t" + cntNum + "\t" + cartDay);
            }


        } catch (SQLException e) {
            System.out.println("SQL문 오류 : " + e.getMessage());throw new RuntimeException(e);
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
        Ex3OracleConnect ex3 = new Ex3OracleConnect();
        ex3.shopWriteData();
    }
}

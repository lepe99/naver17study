package day0103;

import java.sql.*;

public class Ex4MysqlJoin {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    // db에 접근하려면 url과 id, password가 필요하다
    String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username = "root";
    String password = "12345678";

    public Ex4MysqlJoin() {
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
       
        String sql = """
            select name, blood, age, kor, eng, sum
            from person p
            inner join stu s on p.num = s.num
            """;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("이름\t혈액형\t나이\t국어\t영어\t총합");
            System.out.println("=".repeat(60));

            while (rs.next()) {
                String pName = rs.getString("name");
                String pBlood = rs.getString("blood");
                int pAge = rs.getInt("age");
                int pKor = rs.getInt("kor");
                int pEng = rs.getInt("eng");
                int pSum = rs.getInt("sum");

                System.out.println(pName + "\t" + pBlood + "\t" + pAge + "\t" + pKor + "\t" + pEng + "\t" + pSum);
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

    public void personBloodGroup() {
        // 혈액형 별 인원수랑 나이 평균 구하기
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = """
                select blood, count(*) count, round(avg(age), 1) avgage from person
                group by blood order by count
                """;

        conn = this.getConnection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("혈액형\t인원수\t평균나이");
            System.out.println("=".repeat(30));

            while (rs.next()) {
                String pBlood = rs.getString("blood");
                int pCount = rs.getInt("count");
                double pAvgAge = rs.getDouble("avgage");

                System.out.println(pBlood + "\t\t" + pCount + "\t\t" + pAvgAge);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Ex4MysqlJoin ex4 = new Ex4MysqlJoin();
        ex4.personWriteData();
        System.out.println();
        ex4.personBloodGroup();
    }
}

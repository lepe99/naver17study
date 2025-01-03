package day0103;

import java.sql.*;
import java.util.Scanner;

public class Ex5MysqlCRUD {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
    String username = "root";
    String password = "12345678";

    public Ex5MysqlCRUD() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql 드라이버 오류 : " + e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Mysql 접속 오류 : " + e.getMessage());
        }
        return conn;
    }

    public void personInsertData(String name, String blood, int age, String hp) {
        Connection conn = this.getConnection();
        Statement stmt = null;
        // resultSet : 데이터를 가져와야 할 떄(select) 사용

        String sql = "insert into person (name, blood, age, hp, today) values ("
                +"'" + name + "', '" + blood.toUpperCase() + "', '" + age + "', '" + hp + "', now())";
//        System.out.println(sql);

        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void personWriteData() {
        Connection conn = this.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        String sql = """
                select * from person
                """;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("\t\t ** Person Table **");
            System.out.println();
            System.out.println("이름\t나이\t혈액형\t핸드폰\t날짜");
            System.out.println("=".repeat(50));

            while (rs.next()) {
                String today = rs.getString("today").substring(0, 10);
                System.out.println(rs.getString("name") + "\t"
                        + rs.getInt("age") + "\t"
                        + rs.getString("blood") + "\t"
                        + rs.getString("hp") + "\t"
                        + today);
            }
            System.out.println("작성 완료");

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    // 이름 검색해서 출력하는 메서드
    public boolean searchName(String name) {
        int count = 0; // 찾은 인원수를 얻을 변수
        Connection conn = this.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

//        String sql = "select name, blood, age, hp from person where name LIKE '%" + name + "%'";
//        String sql = "select name, blood, age, hp from person where name LIKE '%".concat(name).concat("%'");
        // java concat 사용
        String sql = "select name, blood, age, hp from person where name LIKE concat('%', '" + name + "', '%')";
        // sql concat 사용

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if(rs.next()) {
                do {
                    System.out.println(++count + "번째"
                            + "\n이름 : " + rs.getString("name")
                            + "\n혈액형 : " + rs.getString("blood") + "형"
                            + "\n나이 : " + rs.getInt("age") + "세"
                            + "\n전화번호 : " + rs.getString("hp")
                    );
                    System.out.println("-".repeat(30));
                } while (rs.next());
                System.out.println("조회 완료");
                return true;

            } else {
                System.out.println(name + "을/를 포함한 회원은 없습니다");
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    // 삭제 메서드 excuteUpdate 활용 !
    public void deletePerson(String name) {
        Connection conn = this.getConnection();
        Statement stmt = null;

        String sql = "delete from person where name = '" + name + "'";
        try {
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if (count == 0)
                System.out.println(name + "님은 존재하지 않습니다");
            else
                System.out.println(count + "명 삭제 완료");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 데이터 수정
    public void updatePerson(String name, String blood, int age, String hp) {
        Connection conn = this.getConnection();
        Statement stmt = null;

        String updateAge = age == 0 ? "" : "age = " + age + ", ";
        String updateBlood = blood.equals("0") ? "" : "blood = " + blood + ", ";
        String updateHp = hp.equals("0") ? "" : "hp = " + hp + ", ";
        String inputString = updateAge + updateBlood + updateHp;
        if (inputString.isEmpty()) {
            System.out.println("수정할 내용이 존재하지 않습니다");
            return;
        }
        String sql = "update person set " + inputString.substring(0, inputString.length() - 2) + " where name = '" + name + "'";

        try {
            stmt = conn.createStatement();
//            System.out.println(sql); // 테스트용
            stmt.execute(sql);
            System.out.println("수정 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        Ex5MysqlCRUD ex5 = new Ex5MysqlCRUD();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 데이터 추가, 2. 전체 출력, 3. 이름 검색, 4. 데이터 삭제 5. 데이터 수정 6. 종료");
            System.out.print("메뉴 선택 : ");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1: {
                    System.out.println("데이터를 추가합니다");
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    System.out.print("나이 : ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("혈액형 : ");
                    String blood = sc.nextLine();
                    System.out.print("핸드폰 : ");
                    String hp = sc.nextLine();

                    ex5.personInsertData(name, blood, age, hp);
                    break;
                }
                case 2: {
                    System.out.println("데이터를 조회힙니다");
                    ex5.personWriteData();
                    break;
                }
                case 3: {
                    System.out.println("검색할 이름을 입력하세요");
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    ex5.searchName(name);
                    break;
                }
                case 4: {
                    System.out.println("삭제할 이름을 입력하세요");
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    ex5.deletePerson(name);
                    break;
                }
                case 5: {
                    System.out.println("수정할 이름을 입력하세요");
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    boolean nameExist = ex5.searchName(name);
                    if (nameExist) {
                        System.out.println("수정할 " + name + "님의 정보를 입력해주세요 (0 입력 시 그대로)");
                        System.out.print("나이 : ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("혈액형 : ");
                        String blood = sc.nextLine();
                        System.out.print("핸드폰 : ");
                        String hp = sc.nextLine();
                        ex5.updatePerson(name, blood, age, hp);
                    } else
                        System.out.println(name + "님은 존재하지 않는 회원입니다");
                    break;
                }
                default: {
                    System.out.println("** 프로그램을 종료합니다 **");
                    System.exit(0);
                }
            }
            System.out.println("-".repeat(50));
        }
    }
}

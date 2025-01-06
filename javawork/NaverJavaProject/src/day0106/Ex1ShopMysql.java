package day0106;

import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1ShopMysql {
    MysqlConnect mysqlConnect = new MysqlConnect(); // db 불러올 객체 생성

    //shop 에 상품 추가
    public void insertShop(String prdt, int num, int price) {
        System.out.println("상품을 추가합니다");

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into shop (prdt, num, price, indate) values (?, ?, ?, now())";

        //db 연결
        conn = mysqlConnect.getConnection();

        try {
            pstmt = conn.prepareStatement(sql);//이때 sql문을 검사한다
            //? 갯수만큼 데이터를 넣어준다(바인딩 이라고 한다)
            //첫번째 물음표부터 1번,2번...
            pstmt.setString(1, prdt);//타입별로
            pstmt.setInt(2, num);
            pstmt.setInt(3, price);

            //바인딩을 모두 마친후 실행을 하는데 이때 sql문을 보내면 안됨,그냥 실행만
            pstmt.execute();
            System.out.println("상품추가를 하였습니다");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mysqlConnect.dbClose(pstmt, conn);
        }
    }

    //전체 shop 데이터 출력
    public void writeShop() {
        System.out.println("전체 상품을 출력합니다");
        System.out.println("인덱스\t상품명\t수량\t단가\t총금액\t입고일");
        System.out.println("=".repeat(60));

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from shop order by idx";

        conn = mysqlConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩할게 없으므로 바로 실행
            rs = pstmt.executeQuery();//RenumltSet 을 반환하는 실행문

            while (rs.next()) {
                int num = rs.getInt("num");
                int price = rs.getInt("price");
                int total = num * price;

                System.out.println(rs.getInt("idx") + "\t" + rs.getString("prdt")
                        + "\t" + num + "\t" + price + "\t" + total + "\t" + rs.getString("indate").substring(0, 16));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mysqlConnect.dbClose(rs, pstmt, conn);
        }


    }

    //상품 삭제
    public void deleteShop(String prdt) {
        Connection conn = mysqlConnect.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from shop where prdt = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prdt);
            int count = pstmt.executeUpdate();

            if (count == 0)
                System.out.println(prdt + "라는 상품은 존재하지 않습니다");
            else {
                System.out.println(count + "개의 상품을 삭제하였습니다");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mysqlConnect.dbClose(pstmt, conn);
        }

        System.out.println("상품을 삭제합니다");
    }

    //상품조회
    public void searchPrdt(String prdt) {
        System.out.println("[" + prdt + "] 상품을 조회합니다");
        System.out.println("인덱스\t상품명\t수량\t단가\t총금액\t입고일");
        System.out.println("=".repeat(60));

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from shop where prdt like ? order by idx";

        conn = mysqlConnect.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //? 자리에 바인딩
            pstmt.setString(1, "%" + prdt + "%");

            rs = pstmt.executeQuery();//ResultSet 을 반환하는 실행문

            int count = 0;
            while (rs.next()) {
                count++;
                int num = rs.getInt("num");
                int price = rs.getInt("price");
                int total = num * price;

                System.out.println(rs.getInt("idx") + "\t" + rs.getString("prdt")
                        + "\t" + num + "\t" + price + "\t" + total + "\t" + rs.getString("indate").substring(0, 16));
            }

            if (count == 0)
                System.out.println("[" + prdt + "] 관련 제품이 없습니다");
            else
                System.out.println("[" + prdt + "] 관련 제품이 총" + count + "개 조회되었습니다");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mysqlConnect.dbClose(rs, pstmt, conn);
        }

    }

    /**
     * 상품 수정
     * idx 에 해당하는 num, price 수정
     * excuteUpdate 로 int 타입 반환값을 받아
     * 0 이면 해당 상품이 없습니다
     * 0 이 아니면 해당상품정보를 수정했습니다
     */
    public void updateShop(int idx, int num, int price) {
        Connection conn = mysqlConnect.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update shop set num = case when ? != 0 then ? else num end, " +
                "price = case when ? != 0 then ? else price end " +
                "where idx = ?";

        try {
            pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, num);
                pstmt.setInt(2, num);
                pstmt.setInt(3, price);
                pstmt.setInt(4, price);
            pstmt.setInt(5, idx);

            int count = pstmt.executeUpdate();

            if (count == 0)
                System.out.println("수정된 값이 없습니다");
            else
                System.out.println(idx + "번 인덱스의 값이 정상적으로 수정 되었습니다");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            mysqlConnect.dbClose(pstmt, conn);
        }

        System.out.println("상품을 수정합니다");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex1ShopMysql ex = new Ex1ShopMysql();

        while (true) {
            System.out.println("\t** 상품관리 메뉴 **\n");
            System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제 5.상품수정 6.종료");
            System.out.print("번호 선택(1-6) : ");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1 -> {
                    System.out.println("상품명을 입력하세요");
                    String prdt = sc.nextLine();
                    System.out.println("수량을 입력하세요");
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.println("단가를 입력하세요");
                    int price = Integer.parseInt(sc.nextLine());

                    ex.insertShop(prdt, num, price);
                }

                case 2 -> {
                    ex.writeShop();
                }

                case 3 -> {
                    System.out.println("검색할 상품명을 입력하세요");
                    String prdt = sc.nextLine();
                    ex.searchPrdt(prdt);
                }

                case 4 -> {
                    System.out.println("삭제할 상품명을 입력하세요");
                    String prdt = sc.nextLine();
                    ex.deleteShop(prdt);
                }

                case 5 -> {
                    System.out.println("수정할 인덱스를 입력하세요");
                    int idx = Integer.parseInt(sc.nextLine());
                    System.out.println("변경할 수량을 입력하세요 (미변경시 0 입력)");
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.println("변경할 가격을 입력하세요 (미변경시 0 입력)");
                    int price = Integer.parseInt(sc.nextLine());
                    ex.updateShop(idx, num, price);
                }
                default -> {
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                }
            }
        }
    }

}
package day0107;

import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ex1Model {
    MysqlConnect connect = new MysqlConnect();

    /**
     * 메뉴 테이블 반환
     * @return 2차원 컬렉션 객체 형태로 메뉴 테이블 반환
     */
    public List<Vector<String>> getResData() {
        List<Vector<String>> resData = new ArrayList<>();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from restaurant order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("num"));
                data.add(rs.getString("foodname"));
                data.add(rs.getString("foodsize"));
                data.add(rs.getString("foodprice"));
                resData.add(data);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }


        return resData;
    }

    /**
     * 메뉴 테이블과 예약 테이블 조인 결과 반환
     * @return 메뉴 테이블과 예약 테이블 조인 결과 2차원 컬렉션 객체로 반환
     */
    public List<Vector<String>> getOrderData() {
        List<Vector<String>> resOrder = new ArrayList<>();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = """
                select f.num, ordername, r.foodname, r.foodprice, r.foodsize, ordercnt, bookingday
                from foodorder f
                join restaurant r on r.num = f.num order by num
                """;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("num"));
                data.add(rs.getString("ordername"));
                data.add(rs.getString("foodname"));
                data.add(rs.getString("foodprice"));
                data.add(rs.getString("foodsize"));
                data.add(rs.getString("ordercnt"));
                data.add(rs.getString("bookingday"));
                resOrder.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return resOrder;
    }

    /**
     * 메뉴 등록
     */
    public void menuInsert(Ex1Dto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into restaurant (foodname, foodprice, foodsize) values(?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getFoodName());
            pstmt.setInt(2, dto.getFoodPrice());
            pstmt.setString(3, dto.getFoodSize());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    /**
     * 메뉴 삭제
     */
    public void menuDelete(int idx) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from restaurant where num = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(idx));
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }

    }

    /**
     * 예약 추가
     */
    public void orderInsert(Ex1Dto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into foodorder (num, ordername, ordercnt, bookingday) values (?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getNum());
            pstmt.setString(2, dto.getOrderName());
            pstmt.setInt(3, dto.getOrderCnt());
            pstmt.setString(4, dto.getBookingDay());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }

    }

    /**
     * 예약 삭제
     */
    public void orderDelete(int idx) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from foodorder where num = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(idx));
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }

    }
}

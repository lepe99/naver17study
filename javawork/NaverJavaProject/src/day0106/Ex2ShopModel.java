package day0106;

import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

// db를 처리하기 위한 클래스
public class Ex2ShopModel {

    MysqlConnect connect = new MysqlConnect();

    // 전체 데이터 반환 메서드, List 안에 Vector 형태로 넣어 반환
    public List<Vector<String>> getAllData() {

        List<Vector<String>> list = new Vector<>();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from shop order by idx";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("idx"));
                data.add(rs.getString("prdt"));
                data.add(rs.getString("num"));
                data.add(rs.getString("price"));
                int total = rs.getInt("num") * rs.getInt("price");
                data.add(String.valueOf(total)); // int -> String 변환
                data.add(rs.getString("indate").substring(0, 10)); // 시간은 잘라내기

                list.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    /**
     * INSERT
     */
    public void insertShop(Ex2ShopDto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into shop(prdt,num,price,indate) values(?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);
            // 바인딩
            pstmt.setString(1, dto.getPrdt());
            pstmt.setInt(2, dto.getNum());
            pstmt.setInt(3, dto.getPrice());

            // 실행
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    /**
     * UPDATE
     */
    public void updateShop(Ex2ShopDto dto, int idx) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update shop set prdt=?,num=?,price=? where idx=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPrdt());
            pstmt.setInt(2, dto.getNum());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, idx);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    /**
     * DELETE
     */
    public void deleteShop(int idx) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from shop where idx=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idx);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }
    }

    /** search */
    public Vector<String> prdtSearch(Ex2ShopDto dto) {

        List list = new Vector<>();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from shop where prdt like ? order by idx";

        Vector<String> data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + dto.getPrdt() + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                data = new Vector<>();
                data.add(rs.getString("idx"));
                data.add(rs.getString("prdt"));
                data.add(rs.getString("num"));
                data.add(rs.getString("price"));
                int total = rs.getInt("num") * rs.getInt("price");
                data.add(String.valueOf(total)); // int -> String 변환
                data.add(rs.getString("indate").substring(0, 10)); // 시간은 잘라내기

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }
        return data;
    }
}

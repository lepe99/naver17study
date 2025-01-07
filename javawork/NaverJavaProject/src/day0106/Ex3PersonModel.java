package day0106;

import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class Ex3PersonModel {

    MysqlConnect connect = new MysqlConnect();

    public List<Vector<String>> getPersonInfo() {
        List<Vector<String>> personInfo = new Vector<>();
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from person order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("num"));
                data.add(rs.getString("name"));
                data.add(rs.getString("age"));
                data.add(rs.getString("blood"));
                data.add(rs.getString("hp"));

                personInfo.add(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, pstmt, conn);
        }
        return personInfo;
    }

    public void personInsert(Ex3PersonDto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into person(name,age,blood,hp) values(?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setInt(2, dto.getAge());
            pstmt.setString(3, dto.getBlood());
            pstmt.setString(4, dto.getHp());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(pstmt, conn);
        }

    }

    public void personDelete(int idx) {
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from person where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idx);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

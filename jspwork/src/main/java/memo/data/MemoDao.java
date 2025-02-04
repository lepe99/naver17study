package memo.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemoDao {
    MySQLConnect db = new MySQLConnect();
    
    public void insertData(MemoDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into ajaxmemo (nickname, avatar, message, writeDate)
                values (?, ?, ?, now())
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getNickname());
            ps.setString(2, dto.getAvatar());
            ps.setString(3, dto.getMessage());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void deleteData(int idx) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = "delete from ajaxmemo where idx = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idx);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void updateData(MemoDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update ajaxmemo
                set nickname = ?, avatar = ?, message = ?
                where idx = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getNickname());
            ps.setString(2, dto.getAvatar());
            ps.setString(3, dto.getMessage());
            ps.setInt(4, dto.getIdx());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public List<MemoDto> getAllData(String search) {
        List<MemoDto> list = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select * from ajaxmemo
                where nickname like %?%
                order by idx desc
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            if (search == null) ps.setString(1, "");
            else ps.setString(1, search);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                MemoDto dto = new MemoDto();
                dto.setIdx(rs.getInt("idx"));
                dto.setNickname(rs.getString("nickname"));
                dto.setAvatar(rs.getString("avatar"));
                dto.setMessage(rs.getString("message"));
                dto.setWriteDate(rs.getTimestamp("writeDate"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return list;
    }
}

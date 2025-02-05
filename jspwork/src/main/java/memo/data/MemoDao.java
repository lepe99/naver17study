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
        Connection conn = db.getNCloudConnection();
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
        Connection conn = db.getNCloudConnection();
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
        Connection conn = db.getNCloudConnection();
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
    
    public List<MemoDto> getAllData(int idx, String search) {
        List<MemoDto> list = new ArrayList<>();
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from ajaxmemo ";
        
        if (idx != 0) {
            sql += "where idx = ? ";
        } else if (search != null) {
            sql += "where nickname like ? ";
        }
        
        sql += "order by idx desc";
        
        try {
            ps = conn.prepareStatement(sql);
            if (idx != 0) ps.setInt(1, idx);
            else if (search != null) ps.setString(1, "%" + search + "%");
            
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

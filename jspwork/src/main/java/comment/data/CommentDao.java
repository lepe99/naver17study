package comment.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    MySQLConnect db = new MySQLConnect();
    
    public void insertData(CommentDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = "insert into shop_comment(num, star, message, write_date) values(?, ?, ?, now())";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getNum());
            ps.setInt(2, dto.getStar());
            ps.setString(3, dto.getMessage());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void deleteData(int idx) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = "delete from shop_comment where idx = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idx);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void updateData(CommentDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = "update shop_comment set star = ?, message = ? where idx = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getStar());
            ps.setString(2, dto.getMessage());
            ps.setInt(3, dto.getIdx());
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public List<CommentDto> getAllData(int order, int num) {
        List<CommentDto> list = new ArrayList<>();
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from shop_comment where num = ?";
        
        if (order == 2) {
            sql += " order by idx";
        } else if (order == 1) {
            sql += " order by idx desc";
        }
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                CommentDto dto = new CommentDto();
                dto.setIdx(rs.getInt("idx"));
                dto.setNum(rs.getInt("num"));
                dto.setStar(rs.getInt("star"));
                dto.setMessage(rs.getString("message"));
                dto.setWriteDate(rs.getTimestamp("write_date"));
                list.add(dto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return list;
    }
}

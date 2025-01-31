package simpleBoard.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleCommentDao {
    
    MySQLConnect db = new MySQLConnect();
    
    public List<SimpleCommentDto> getThisComment(int boardId) {
        List<SimpleCommentDto> list = new ArrayList<>();
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = """
                select * from simple_comment
                where board_id = ?
                order by comment_idx desc
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, boardId);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                SimpleCommentDto dto = new SimpleCommentDto();
                dto.setCommentIdx(rs.getInt("comment_idx"));
                dto.setBoardId(rs.getInt("board_id"));
                dto.setWriter(rs.getString("writer"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getTimestamp("write_date"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return list;
    }
    
    public void insertComment(SimpleCommentDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into simple_comment (board_id, writer, content, write_date)
                values (?, ?, ?, now())
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getBoardId());
            ps.setString(2, dto.getWriter());
            ps.setString(3, dto.getContent());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void deleteComment(int commentIdx) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = "delete from simple_comment where comment_idx = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, commentIdx);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
        
    }
    
    public void updateComment(SimpleCommentDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update simple_comment
                set content = ?
                where comment_idx = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getContent());
            ps.setInt(2, dto.getCommentIdx());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
}

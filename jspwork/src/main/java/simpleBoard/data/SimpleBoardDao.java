package simpleBoard.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleBoardDao {
    
    MySQLConnect db = new MySQLConnect();
    
    public List<SimpleBoardDto> getAllData() {
        List<SimpleBoardDto> list = new ArrayList<>();
        
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from simple_board order by board_id desc";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                SimpleBoardDto dto = new SimpleBoardDto();
                dto.setBoardId(rs.getInt("board_id"));
                dto.setWriter(rs.getString("writer"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadCount(rs.getString("read_count"));
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
    
    public void insertBoard(SimpleBoardDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into simple_board (writer, subject, content, write_date)
                values (?, ?, ?, now())
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getWriter());
            ps.setString(2, dto.getSubject());
            ps.setString(3, dto.getContent());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public SimpleBoardDto getData(int boardId) {
        SimpleBoardDto dto = new SimpleBoardDto();
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from simple_board where board_id = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, boardId);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                dto.setBoardId(rs.getInt("board_id"));
                dto.setWriter(rs.getString("writer"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadCount(rs.getString("read_count"));
                dto.setWriteDate(rs.getTimestamp("write_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return dto;
    }
    
    public void updateReadCount(int boardId) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update simple_board
                set read_count = read_count + 1
                where board_id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, boardId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void  deleteBoard(int boardId) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = "delete from simple_board where board_id = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, boardId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void updateBoard(SimpleBoardDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update simple_board
                set writer = ?, subject = ?, content = ?
                where board_id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getWriter());
            ps.setString(2, dto.getSubject());
            ps.setString(3, dto.getContent());
            ps.setInt(4, dto.getBoardId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
       
        
    }
}

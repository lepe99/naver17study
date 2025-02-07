// CategoriesDao.java
package dao;

import dto.CategoriesDto;
import util.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao {
    MySQLConnect db = new MySQLConnect();
    
    /**
     * 카테고리 생성
     * @param dto 카테고리 정보
     */
    public void createCategory(CategoriesDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                insert into categories
                (user_id, name, category_type)
                values (?, ?, ?)
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getUserId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getCategoryType());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 카테고리 삭제
     * @param id 카테고리 아이디
     */
    public void deleteCategory(int id) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                delete from categories
                where id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 카테고리 수정
     * @param dto 카테고리 정보
     */
    public void updateCategory(CategoriesDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update categories
                set name = ?, category_type = ?
                where id = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getCategoryType());
            ps.setInt(3, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    /**
     * 카테고리 조회
     * @return 카테고리 정보
     */
    public List<CategoriesDto> getCategories() {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoriesDto> list = new ArrayList<>();
        
        String sql = """
                select id, user_id, name, category_type
                from categories
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                CategoriesDto dto = new CategoriesDto();
                dto.setId(rs.getInt("id"));
                dto.setUserId(rs.getInt("user_id"));
                dto.setName(rs.getString("name"));
                dto.setCategoryType(rs.getString("category_type"));
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

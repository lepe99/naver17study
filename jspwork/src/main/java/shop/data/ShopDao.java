package shop.data;

import db.connect.MySQLConnect;
import shop.data.ShopDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    MySQLConnect connect = new MySQLConnect();
    
    public List<ShopDto> getAllData(String search) {
        List<ShopDto> list = new ArrayList<>();
        
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        
        if (search == null) {
            sql = "select * from shop order by idx";
        } else
            sql = "select * from shop where prdt like '%" + search + "%' order by idx";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ShopDto dto = new ShopDto();
                dto.setIdx(rs.getInt("idx"));
                dto.setPrdt(rs.getString("prdt"));
                dto.setNum(rs.getInt("num"));
                dto.setPrice(rs.getInt("price"));
                dto.setInDate(rs.getTimestamp("indate"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, ps, conn);
        }
        return list;
    }
}

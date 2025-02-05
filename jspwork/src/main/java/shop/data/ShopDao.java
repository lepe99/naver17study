package shop.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    MySQLConnect db = new MySQLConnect();
    
    public void insertData(ShopDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        String sql = """
                insert into shop (prdt_name, prdt_color, prdt_cnt, prdt_price, prdt_image, prdt_date_in, date_write)
                values (?, ?, ?, ?, ?, ?, now())
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPrdtName());
            ps.setString(2, dto.getPrdtColor());
            ps.setInt(3, dto.getPrdtCnt());
            ps.setInt(4, dto.getPrdtPrice());
            ps.setString(5, dto.getPrdtImg());
            ps.setString(6, dto.getPrdtDateIn());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void updateData(ShopDto dto) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        String sql = """
                update shop
                set prdt_name = ?, prdt_color = ?, prdt_cnt = ?, prdt_price = ?, prdt_image = ?, prdt_date_in = ?
                where num = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPrdtName());
            ps.setString(2, dto.getPrdtColor());
            ps.setInt(3, dto.getPrdtCnt());
            ps.setInt(4, dto.getPrdtPrice());
            ps.setString(5, dto.getPrdtImg());
            ps.setString(6, dto.getPrdtDateIn());
            ps.setInt(7, dto.getNum());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public void deleteData(int num) {
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        String sql = "delete from shop where num = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(ps, conn);
        }
    }
    
    public List<ShopDto> getData(int order, int num, String search) {
        List<ShopDto> list = new ArrayList<>();
        Connection conn = db.getNCloudConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from shop";
        
        if (num != 0) {
            sql += " where num = ?";
        } else if (search != null) {
            sql += " where prdt_name like ?";
        }
        
        switch (order) {
            case 1 -> sql += " order by num";
            case 2 -> sql += " order by prdt_price desc";
            case 3 -> sql += " order by prdt_price";
            case 4 -> sql += " order by prdt_name";
        }
        
        try {
            ps = conn.prepareStatement(sql);
            if (num != 0) {
                ps.setInt(1, num);
            } else if (search != null) {
                ps.setString(1, "%" + search + "%");
            }
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ShopDto dto = new ShopDto();
                dto.setNum(rs.getInt("num"));
                dto.setPrdtName(rs.getString("prdt_name"));
                dto.setPrdtColor(rs.getString("prdt_color"));
                dto.setPrdtCnt(rs.getInt("prdt_cnt"));
                dto.setPrdtPrice(rs.getInt("prdt_price"));
                dto.setPrdtImg(rs.getString("prdt_image"));
                dto.setPrdtDateIn(rs.getString("prdt_date_in"));
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

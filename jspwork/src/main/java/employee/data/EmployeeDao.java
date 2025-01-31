package employee.data;

import db.connect.MySQLConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    
    MySQLConnect connect = new MySQLConnect();
    
    public List<EmployeeDto> getAllData(String search) {
        List<EmployeeDto> list = new ArrayList<>();
        
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        
        if (search == null) {
            sql = "select * from employee order by num";
        } else
            sql = "select * from employee where empName like '%" + search + "%' order by num";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EmployeeDto dto = new EmployeeDto();
                dto.setNum(rs.getInt("num"));
                dto.setEmpName(rs.getString("empName"));
                dto.setEmpPhoto(rs.getString("empPhoto"));
                dto.setEmpJoin(rs.getString("empJoin"));
                dto.setEmpBirth(rs.getInt("empBirth"));
                dto.setEmpBlood(rs.getString("empBlood"));
                dto.setWriteDate(rs.getTimestamp("writeDate"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, ps, conn);
        }
        return list;
    }
    
    public void insertData(EmployeeDto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        String sql = """
                insert into employee (empName, empPhoto, empJoin, empBirth, empBlood, writeDate)
                values (?, ?, ?, ?, ?, now())
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            // 바인딩
            ps.setString(1, dto.getEmpName());
            ps.setString(2, dto.getEmpPhoto());
            ps.setString(3, dto.getEmpJoin());
            ps.setInt(4, dto.getEmpBirth());
            ps.setString(5, dto.getEmpBlood());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(ps, conn);
        }
    }
    
    public EmployeeDto getEmployeeData(int num) {
        EmployeeDto dto = new EmployeeDto();
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select * from employee where num = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            // 바인딩 후 실행
            ps.setInt(1, num);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setEmpName(rs.getString("empName"));
                dto.setEmpPhoto(rs.getString("empPhoto"));
                dto.setEmpJoin(rs.getString("empJoin"));
                dto.setEmpBirth(rs.getInt("empBirth"));
                dto.setEmpBlood(rs.getString("empBlood"));
                dto.setWriteDate(rs.getTimestamp("writeDate"));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(rs, ps, conn);
        }
        return dto;
    }
    
    public void updateEmployeeData(EmployeeDto dto) {
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        
        String sql = """
                update employee
                set empName = ?, empPhoto = ?, empJoin = ?, empBirth = ?, empBlood = ?
                where num = ?
                """;
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getEmpName());
            ps.setString(2, dto.getEmpPhoto());
            ps.setString(3, dto.getEmpJoin());
            ps.setInt(4, dto.getEmpBirth());
            ps.setString(5, dto.getEmpBlood());
            ps.setInt(6, dto.getNum());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(ps, conn);
        }
    }
    
    public void deleteEmployeeData(int num) {
        Connection conn = connect.getConnection();
        PreparedStatement ps = null;
        
        String sql = "delete from employee where num = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connect.dbClose(ps, conn);
        }
    }
}

